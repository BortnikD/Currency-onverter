package org.bortnik.converter.infrastructure.repositories.spring

import org.bortnik.converter.domain.entities.ExchangeRate
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface SpringExchangeRateRepository : CoroutineCrudRepository<ExchangeRate, UUID> {

    suspend fun findBySessionId(sessionId: Long) : List<ExchangeRate>?

}
