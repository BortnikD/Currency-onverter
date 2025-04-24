package org.bortnik.converter.domain.repositories

import org.bortnik.converter.domain.dto.exchangeRate.ExchangeRate


interface ExchangeRateRepository {

    suspend fun findBySessionId(sessionId: Long) : List<ExchangeRate>

    suspend fun save(exchangeRate: ExchangeRate): ExchangeRate

}