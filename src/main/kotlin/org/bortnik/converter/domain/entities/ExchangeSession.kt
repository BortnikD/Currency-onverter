package org.bortnik.converter.domain.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate


@Table("exchange_sessions")
data class ExchangeSession (
    @Id
    val id: Long? = null,
    val baseCurrency: String,
    val date: LocalDate
)

