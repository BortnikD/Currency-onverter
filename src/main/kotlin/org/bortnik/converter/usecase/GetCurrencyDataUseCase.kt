package org.bortnik.converter.usecase

import org.bortnik.converter.domain.dto.Currency
import org.bortnik.converter.domain.repositories.CurrencyRepository
import org.springframework.stereotype.Service

@Service
class GetCurrencyDataUseCase(
    private val currencyRepository: CurrencyRepository
) {

    suspend fun getCurrencyDataOfName(name: String, amount: Double): Currency {
        return currencyRepository.getCurrencyDataOfNameAndAmount(name, amount)
    }

    suspend fun convertCurrencies(from: String, to: String, amount: Double = 1.0): Double {
        val response = currencyRepository.getCurrencyDataOfNameAndAmount(from, amount)
        return response.rates[to] ?: throw IllegalArgumentException()
    }

}
