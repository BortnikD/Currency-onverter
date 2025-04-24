package org.bortnik.converter.domain.repositories

import org.bortnik.converter.domain.dto.exchangeSession.ExchangeSession


interface ExchangeSessionRepository {

    suspend fun findByBaseCurrency(baseCurrency: String): ExchangeSession?

    suspend fun findByBaseCurrencyOrderByDateDesc(baseCurrency: String): ExchangeSession?

    suspend fun save(exchangeSession: ExchangeSession): ExchangeSession?

}