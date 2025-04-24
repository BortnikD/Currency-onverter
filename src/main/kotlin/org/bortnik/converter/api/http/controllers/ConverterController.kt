package org.bortnik.converter.api.http.controllers

import org.bortnik.converter.domain.dto.Currency
import org.bortnik.converter.domain.exceptions.currency.InvalidRequestException
import org.bortnik.converter.usecase.GetCurrencyDataUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/converter")
class ConverterController(
    private val currencyUseCase: GetCurrencyDataUseCase
) {

    @GetMapping
    suspend fun getCurrency(
        @RequestParam name: String,
        @RequestParam amount: Double = 1.0
    ): Currency {
        if (name.length != 3) {
            throw InvalidRequestException("The name length must be equal to 3")
        }
        if (amount <= 0) {
            throw InvalidRequestException("The amount must be greater than 0")
        }
        return currencyUseCase.getCurrencyDataOfNameAndAmount(name, amount)
    }

    @GetMapping("/compare")
    suspend fun compareCurrencies(
        @RequestParam from: String,
        @RequestParam to: String,
        @RequestParam amount: Double = 1.0
    ): Double {
        if (from.length != 3 || to.length != 3) {
            throw InvalidRequestException("The name length must be equal to 3")
        }
        if (amount <= 0) {
            throw InvalidRequestException("The amount must be greater than 0")
        }
        return currencyUseCase.convertCurrencies(from, to, amount)
    }
}
