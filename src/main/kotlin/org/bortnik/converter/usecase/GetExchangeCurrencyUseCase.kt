package org.bortnik.converter.usecase

import org.bortnik.converter.domain.dto.ExchangeSessionWithRates
import org.bortnik.converter.domain.dto.exchangeSession.toDto
import org.bortnik.converter.domain.dto.exchangeRate.toDto
import org.bortnik.converter.domain.repositories.ExchangeSessionRepository
import org.bortnik.converter.infrastructure.repositories.ExchangeRatesRepository

class GetExchangeCurrencyUseCase (
    private val sessionRepository: ExchangeSessionRepository,
    private val ratesRepository: ExchangeRatesRepository
) {

    suspend fun getExchangeCurrency(currency: String): ExchangeSessionWithRates {
        val session = sessionRepository.findByBaseCurrencyOrderByDateDesc(currency) ?: TODO()
        val sessionRates = ratesRepository.findBySessionId(session.id!!) ?: TODO()
        return ExchangeSessionWithRates(
            session.toDto(),
            sessionRates.map { it.toDto() }
        )
    }

}