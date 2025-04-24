package org.bortnik.converter.usecase

import org.bortnik.converter.domain.dto.ExchangeSessionWithRates
import org.bortnik.converter.domain.repositories.ExchangeSessionRepository
import org.bortnik.converter.domain.repositories.ExchangeRateRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class GetExchangeCurrencyUseCase (
    private val sessionRepository: ExchangeSessionRepository,
    private val ratesRepository: ExchangeRateRepository
) {

    @Cacheable(value = ["CurrencyExchange"], key = "#currency")
    suspend fun findByBaseCurrencyOrderByDateDesc(currency: String): ExchangeSessionWithRates {
        val session = sessionRepository.findByBaseCurrencyOrderByDateDesc(currency)
        val sessionRates = ratesRepository.findBySessionId(session.id!!)
        return ExchangeSessionWithRates(
            session,
            sessionRates
        )
    }

}
