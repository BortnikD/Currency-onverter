package org.bortnik.converter.domain.entities

import java.time.LocalDate

data class ExchageSession (
    val id: ExchangeSessionId,
    val baseCurrency: String,
    val date: LocalDate
)

data class ExchangeSessionId (val id: Long)
