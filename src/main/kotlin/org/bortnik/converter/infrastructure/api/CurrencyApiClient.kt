package org.bortnik.converter.infrastructure.api

import org.bortnik.converter.domain.dto.Currency
import org.bortnik.converter.domain.repositories.CurrencyRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody


@Repository
class CurrencyApiClient: CurrencyRepository {
    private val currencyUrl = "https://api.frankfurter.dev/v1"
    private val webClient = WebClient.builder()
        .baseUrl(currencyUrl)
        .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
        .build()

    override suspend fun getCurrencyDataOfNameAndAmount(name: String, amount: Double): Currency {
        return webClient.get()
            .uri("/latest?base={name}&amount={amount}", name, amount)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus({ it.isError }) { response ->
                throw RuntimeException("API error: ${response.statusCode()}")
            }
            .awaitBody<Currency>()
    }

}
