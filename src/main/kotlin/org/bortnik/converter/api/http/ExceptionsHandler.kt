package org.bortnik.converter.api.http

import org.bortnik.converter.domain.exceptions.CurrencyApiException
import org.bortnik.converter.domain.exceptions.CurrencyNotFoundException
import org.bortnik.converter.domain.exceptions.InvalidRequestException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionsHandler {

    @ExceptionHandler(CurrencyNotFoundException::class)
    fun handleCurrencyNotFound(e: CurrencyNotFoundException): ResponseEntity<ApiError> {
        return ResponseEntity
            .status(404)
            .body(
                ApiError(message = e.message ?: "Currency not found")
            )
    }

    @ExceptionHandler(InvalidRequestException::class)
    fun handleInvalidRequestException(e: InvalidRequestException): ResponseEntity<ApiError> {
        return ResponseEntity
            .status(400)
            .body(
                ApiError(message = e.message ?: "Invalid request parameters")
            )
    }

    @ExceptionHandler(CurrencyApiException::class)
    fun handleCurrencyApiException(e: CurrencyApiException): ResponseEntity<ApiError> {
        return ResponseEntity
            .status(500)
            .body(
                ApiError(message = e.message ?: "Internal Server Error")
            )
    }

//    @ExceptionHandler(Exception::class)
//    fun handleGenericException(e: Exception): ResponseEntity<ApiError> {
//        return ResponseEntity
//            .status(500)
//            .body(ApiError(
//                message = "Internal server error"
//            ))
//    }

}