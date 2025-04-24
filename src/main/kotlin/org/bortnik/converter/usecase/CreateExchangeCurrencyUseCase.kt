package org.bortnik.converter.usecase

import org.bortnik.converter.domain.dto.exchangeRate.ExchangeRate
import org.bortnik.converter.domain.dto.exchangeSession.ExchangeSession
import org.bortnik.converter.domain.repositories.ExchangeRateRepository
import org.bortnik.converter.domain.repositories.ExchangeSessionRepository

class CreateExchangeCurrencyUseCase (
    private val sessionRepository: ExchangeSessionRepository,
    private val rateRepository: ExchangeRateRepository
) {

    suspend fun sessionSave(exchangeSession: ExchangeSession): ExchangeSession {
        return sessionRepository.save(exchangeSession)
    }

    suspend fun rateSave(exchangeRate: ExchangeRate): ExchangeRate {
        return rateRepository.save(exchangeRate)
    }

}