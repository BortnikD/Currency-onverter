package org.bortnik.converter.domain.dto

import org.bortnik.converter.domain.dto.exchangeRate.ExchangeRate
import org.bortnik.converter.domain.dto.exchangeSession.ExchangeSession

data class ExchangeSessionWithRates(
    val session: ExchangeSession,
    val rates: List<ExchangeRate>
)