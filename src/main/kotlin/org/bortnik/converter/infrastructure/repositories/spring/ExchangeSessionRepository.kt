package org.bortnik.converter.infrastructure.repositories.spring

import org.bortnik.converter.domain.entities.ExchangeSession
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpringExchangeSessionRepository : CoroutineCrudRepository<ExchangeSession, UUID> {

    suspend fun findByBaseCurrency(baseCurrency: String): ExchangeSession?

    suspend fun findByBaseCurrencyOrderByDateDesc(baseCurrency: String): ExchangeSession?

}
