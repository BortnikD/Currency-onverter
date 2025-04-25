package org.bortnik.converter.usecase

import org.bortnik.converter.domain.dto.ExchangeSessionWithRates
import org.bortnik.converter.domain.dto.exchangeRate.ExchangeRate
import org.bortnik.converter.domain.dto.exchangeSession.ExchangeSession
import org.bortnik.converter.domain.repositories.ExchangeRateRepository
import org.bortnik.converter.domain.repositories.ExchangeSessionRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class CreateExchangeCurrencyUseCase (
    private val sessionRepository: ExchangeSessionRepository,
    private val rateRepository: ExchangeRateRepository
) {

    @CacheEvict(value = ["CurrencyExchange"], key = "#exchangeSession.baseCurrency")
    suspend fun sessionSave(exchangeSession: ExchangeSession): ExchangeSession {
        return sessionRepository.save(exchangeSession)
    }

    @CacheEvict(value = ["CurrencyExchange"], key = "#exchangeRate.sessionId")
    suspend fun rateSave(exchangeRate: ExchangeRate): ExchangeRate {
        return rateRepository.save(exchangeRate)
    }

    @CacheEvict(value = ["CurrencyExchange"], key = "#sessionWithRates.session.baseCurrency")
    suspend fun saveSessionWithRates(sessionWithRates: ExchangeSessionWithRates): ExchangeSessionWithRates {
        val savedSession = sessionRepository.save(sessionWithRates.session)
        val savedRates = sessionWithRates.rates.map { rate ->
            val rateWithSessionId = rate.copy(sessionId = savedSession.id!!)
            rateRepository.save(rateWithSessionId)
        }
        return ExchangeSessionWithRates(savedSession, savedRates)
    }

}
