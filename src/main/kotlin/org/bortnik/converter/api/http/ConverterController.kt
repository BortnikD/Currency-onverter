package org.bortnik.converter.api.http

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import org.bortnik.converter.domain.dto.Currency
import org.bortnik.converter.usecase.GetCurrencyDataUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/converter")
class ConverterController(
    private val currencyDataUseCase: GetCurrencyDataUseCase
) {

    @GetMapping
    suspend fun getCurrency(
        @RequestParam @NotBlank @Size(min = 2, max = 3) name: String,
        @RequestParam @Positive amount: Double = 1.0
    ): ResponseEntity<Currency> {
            return ResponseEntity.ok(currencyDataUseCase.getCurrencyDataOfNameAndAmount(name, amount))
    }

    @GetMapping("/compare")
    suspend fun compareCurrencies(
        @RequestParam @NotBlank @Size(min = 2, max = 3) from: String,
        @RequestParam @NotBlank @Size(min = 2, max = 3) to: String,
        @RequestParam @Positive amount: Double = 1.0
    ): ResponseEntity<Double> {
        return ResponseEntity.ok(currencyDataUseCase.convertCurrencies(from, to, amount))
    }

}
