package org.bortnik.converter.domain.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class ExchangeRate (
    @Id
    val id: Long? = null,
    val sessionId: Long,
    val currency: String,
    val rate: Double
)
