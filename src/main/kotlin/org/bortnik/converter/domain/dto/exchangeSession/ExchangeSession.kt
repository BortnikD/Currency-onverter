package org.bortnik.converter.domain.dto.exchangeSession

import java.time.LocalDate

data class ExchangeSession (
    val id: Long? = null,
    val baseCurrency: String,
    val date: LocalDate
)

