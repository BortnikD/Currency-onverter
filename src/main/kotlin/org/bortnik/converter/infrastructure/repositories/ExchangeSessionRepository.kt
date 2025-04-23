package org.bortnik.converter.infrastructure.repositories

import org.bortnik.converter.domain.entities.ExchangeSession
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ExchangeSessionRepository : CoroutineCrudRepository<ExchangeSession, UUID> {

    suspend fun findByBaseCurrency(baseCurrency: String): ExchangeSession?

    suspend fun findByBaseCurrencyOrderByDateDesc(baseCurrency: String): ExchangeSession?

}
