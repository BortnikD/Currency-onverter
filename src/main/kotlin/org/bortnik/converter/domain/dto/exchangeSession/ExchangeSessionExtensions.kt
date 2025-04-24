package org.bortnik.converter.domain.dto.exchangeSession

import org.bortnik.converter.domain.entities.ExchangeSession
import org.bortnik.converter.domain.dto.exchangeSession.ExchangeSession as ExchangeSessionDTO

fun ExchangeSession.toDto() =
    ExchangeSessionDTO(
        this.id,
        this.baseCurrency,
        this.date
    )


fun ExchangeSessionDTO.toEntity() =
    ExchangeSession(
        baseCurrency = this.baseCurrency,
        date = this.date
    )