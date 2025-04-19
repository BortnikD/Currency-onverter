package org.bortnik.converter.usecase

import org.bortnik.converter.domain.dto.Currency
import org.bortnik.converter.domain.repositories.CurrencyRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class GetCurrencyDataUseCase(
    private val currencyRepository: CurrencyRepository
) {

    @Cacheable(value = ["Currency"], key = "#name + '_' + #amount")
    suspend fun getCurrencyDataOfNameAndAmount(name: String, amount: Double): Currency {
        return currencyRepository.getCurrencyDataOfNameAndAmount(name, amount)
    }

    @Cacheable(value = ["CurrencyConverted"], key = "#from + '_to_' + #to + '_amount_' + #amount")
    suspend fun convertCurrencies(from: String, to: String, amount: Double = 1.0): Double {
        val response = currencyRepository.getCurrencyDataOfNameAndAmount(from, amount)
        return response.rates[to]!!
    }

}
