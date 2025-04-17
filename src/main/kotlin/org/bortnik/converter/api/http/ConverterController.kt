package org.bortnik.converter.api.http

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import org.bortnik.converter.domain.dto.Currency
import org.bortnik.converter.usecase.GetCurrencyDataUseCase
import org.springframework.http.HttpStatus
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
        @RequestParam @NotBlank @Size(min = 3, max = 3) name: String,
        @RequestParam @Positive amount: Double = 1.0
    ): ResponseEntity<Currency> {

        if(name.length > 3) {
            ResponseEntity.status(400).body("Incorrect currency name")
        }

        return try {
            ResponseEntity.ok(currencyDataUseCase.getCurrencyDataOfName(name, amount))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }

    @GetMapping("/compare")
    suspend fun compareCurrencies(
        @RequestParam @NotBlank @Size(min = 3, max = 3) from: String,
        @RequestParam @NotBlank @Size(min = 3, max = 3) to: String,
        @RequestParam @Positive amount: Double = 1.0
    ): ResponseEntity<Double> {

        if(from.length > 3 || to.length > 3) {
            ResponseEntity.status(400).body("Incorrect currency name")
        }

        return try {
            ResponseEntity.ok(currencyDataUseCase.convertCurrencies(from, to, amount))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }

    }

}
