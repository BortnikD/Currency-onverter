package org.bortnik.converter.domain.repositories

import org.bortnik.converter.domain.entities.ExchangeSession


interface ExchangeSessionRepository {

    fun findByBaseCurrency(baseCurrency: String): ExchangeSession?

    fun findByBaseCurrencyOrderByDateDesc(baseCurrency: String): ExchangeSession?

}