package org.bortnik.converter.domain.entities

data class ExchangeRate (
    val id: Long,
    val sessionId: ExchangeSessionId,
    val currency: String,
    val rate: Double
)

data class ExchangeRatesId (val id: Long)