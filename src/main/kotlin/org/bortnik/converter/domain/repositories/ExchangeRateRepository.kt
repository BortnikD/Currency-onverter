package org.bortnik.converter.domain.repositories

import org.bortnik.converter.domain.entities.ExchangeRate


interface ExchangeRateRepository {

    fun findBySessionId(sessionId: Long) : ExchangeRate?

}