package org.bortnik.converter.api.http

import org.bortnik.converter.domain.dto.Currency
import org.bortnik.converter.domain.exceptions.InvalidRequestException
import org.bortnik.converter.usecase.GetCurrencyDataUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// TODO убрать валидацию, добавить их внутрь
@RestController
@RequestMapping("api/converter")
class ConverterController(
    private val currencyUseCase: GetCurrencyDataUseCase
) {

    @GetMapping
    suspend fun getCurrency(
        @RequestParam name: String,
        @RequestParam amount: Double = 1.0
    ): ResponseEntity<Currency> {
        if (name.length != 3) {
           throw InvalidRequestException("The name length must be equal to 3")
        }
        if (amount <= 0) {
            throw InvalidRequestException("The amount must be greet then 0")
        }
        return ResponseEntity.ok(currencyUseCase.getCurrencyDataOfNameAndAmount(name, amount))
    }

    @GetMapping("/compare")
    suspend fun compareCurrencies(
        @RequestParam from: String,
        @RequestParam to: String,
        @RequestParam amount: Double = 1.0
    ): ResponseEntity<Double> {
        if (from.length != 3 || to.length != 3) {
            throw InvalidRequestException("The name length must be equal to 3")
        }
        if (amount <= 0) {
            throw InvalidRequestException("The amount must be greet then 0")
        }

        return ResponseEntity.ok(currencyUseCase.convertCurrencies(from, to, amount))
    }

}
