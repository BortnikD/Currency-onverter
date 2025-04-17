package org.bortnik.converter.domain.repositories

import org.bortnik.converter.domain.dto.Currency

interface CurrencyRepository {
    suspend fun getCurrencyDataOfNameAndAmount(name: String, amount: Double): Currency
}