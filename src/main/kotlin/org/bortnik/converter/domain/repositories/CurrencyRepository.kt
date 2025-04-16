package org.bortnik.converter.domain.repositories

import org.bortnik.converter.domain.dto.CurrencyResponse

interface CurrencyRepository {
    suspend fun getCurrencyDataOfNameAndAmount(name: String, amount: Double): CurrencyResponse
}