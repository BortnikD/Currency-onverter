package org.bortnik.converter.infrastructure.repositories.impl

import org.bortnik.converter.domain.dto.exchangeRate.ExchangeRate
import org.bortnik.converter.domain.dto.exchangeRate.toDto
import org.bortnik.converter.domain.dto.exchangeRate.toEntity
import org.bortnik.converter.domain.exceptions.rate.RateNotFound
import org.bortnik.converter.domain.repositories.ExchangeRateRepository
import org.bortnik.converter.infrastructure.repositories.spring.SpringExchangeRateRepository
import org.springframework.stereotype.Repository

@Repository
class ExchangeRateRepositoryImpl(
    private val repo: SpringExchangeRateRepository
) : ExchangeRateRepository {

    override suspend fun findBySessionId(sessionId: Long): List<ExchangeRate> {
        val rates = repo.findBySessionId(sessionId)
            ?: throw RateNotFound("Rates not found")
        return rates.map { it.toDto() }
    }

    override suspend fun save(exchangeRate: ExchangeRate): ExchangeRate {
        return repo.save(exchangeRate.toEntity()).toDto()
    }

}
