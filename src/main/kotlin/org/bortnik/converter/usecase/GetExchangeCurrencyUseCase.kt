package org.bortnik.converter.usecase

import org.bortnik.converter.domain.dto.ExchangeSessionWithRates
import org.bortnik.converter.domain.repositories.ExchangeSessionRepository
import org.bortnik.converter.domain.repositories.ExchangeRateRepository

// TODO добавить корректную обработку ошибок, вместо TODO()
// TODO добавить кэширование результатов
// TODO написать контроллер для данного кейса

class GetExchangeCurrencyUseCase (
    private val sessionRepository: ExchangeSessionRepository,
    private val ratesRepository: ExchangeRateRepository
) {

    suspend fun getExchangeCurrency(currency: String): ExchangeSessionWithRates {
        val session = sessionRepository.findByBaseCurrencyOrderByDateDesc(currency) ?: TODO()
        val sessionRates = ratesRepository.findBySessionId(session.id!!) ?: TODO()
        return ExchangeSessionWithRates(
            session,
            sessionRates
        )
    }

}
