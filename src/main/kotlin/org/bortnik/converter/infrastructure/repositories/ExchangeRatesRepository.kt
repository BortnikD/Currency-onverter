package org.bortnik.converter.infrastructure.repositories


import org.bortnik.converter.domain.entities.ExchangeRate
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface ExchangeRatesRepository : CoroutineCrudRepository<ExchangeRate, UUID> {

    fun findBySessionId(sessionId: Long) : List<ExchangeRate>?

}
