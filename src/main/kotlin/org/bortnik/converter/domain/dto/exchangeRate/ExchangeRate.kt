package org.bortnik.converter.domain.dto.exchangeRate


data class ExchangeRate (
    val id: Long? = null,
    val sessionId: Long,
    val currency: String,
    val rate: Double
)
