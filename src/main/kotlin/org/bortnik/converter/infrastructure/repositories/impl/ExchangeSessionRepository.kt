package org.bortnik.converter.infrastructure.repositories.impl

import org.bortnik.converter.domain.dto.exchangeSession.ExchangeSession
import org.bortnik.converter.domain.dto.exchangeSession.toDto
import org.bortnik.converter.domain.dto.exchangeSession.toEntity
import org.bortnik.converter.domain.exceptions.session.SessionCreateError
import org.bortnik.converter.domain.exceptions.session.SessionNotFound
import org.bortnik.converter.domain.repositories.ExchangeSessionRepository
import org.bortnik.converter.infrastructure.repositories.spring.SpringExchangeSessionRepository
import org.springframework.stereotype.Repository

@Repository
class ExchangeSessionRepositoryImpl(
    private val repo: SpringExchangeSessionRepository
) : ExchangeSessionRepository {

    override suspend fun findByBaseCurrency(baseCurrency: String): ExchangeSession {
        val session = repo.findByBaseCurrency(baseCurrency) ?: throw SessionNotFound("session not found")
        return session.toDto()
    }

    override suspend fun findByBaseCurrencyOrderByDateDesc(baseCurrency: String): ExchangeSession {
        val session = repo.findByBaseCurrencyOrderByDateDesc(baseCurrency) ?: throw SessionNotFound("session not found")
        return session.toDto()
    }

    override suspend fun save(exchangeSession: ExchangeSession): ExchangeSession {
        try {
            return repo.save(exchangeSession.toEntity()).toDto()
        } catch (e: Exception) {
            throw SessionCreateError("Error with create session")
        }
    }

}
