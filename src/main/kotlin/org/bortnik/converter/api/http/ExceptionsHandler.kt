package org.bortnik.converter.api.http

import org.bortnik.converter.domain.exceptions.CurrencyApiException
import org.bortnik.converter.domain.exceptions.CurrencyNotFoundException
import org.bortnik.converter.domain.exceptions.InvalidRequestException
import org.bortnik.converter.domain.exceptions.rate.RateCreateError
import org.bortnik.converter.domain.exceptions.rate.RateNotFound
import org.bortnik.converter.domain.exceptions.session.SessionCreateError
import org.bortnik.converter.domain.exceptions.session.SessionNotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.MissingRequestValueException

@RestControllerAdvice
class ExceptionsHandler {

    @ExceptionHandler(CurrencyNotFoundException::class)
    fun handleCurrencyNotFound(e: CurrencyNotFoundException): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Currency Not Found",
                message = e.message ?: "Currency not found",
                status = HttpStatus.NOT_FOUND
            )
        )
    }

    @ExceptionHandler(InvalidRequestException::class)
    fun handleInvalidRequestException(e: InvalidRequestException): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Invalid Request",
                message = e.message ?: "Invalid request parameters",
                status = HttpStatus.BAD_REQUEST
            )
        )
    }

    @ExceptionHandler(CurrencyApiException::class)
    fun handleCurrencyApiException(e: CurrencyApiException): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Currency Api Exception",
                message = e.message ?: "Internal Server Error",
                status = HttpStatus.INTERNAL_SERVER_ERROR
            )
        )
    }

    @ExceptionHandler(RateNotFound::class)
    fun handleRateNotFound(e: RateNotFound): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Rate not found",
                message = e.message ?: "rate not found",
                status = HttpStatus.NOT_FOUND
            )
        )
    }

    @ExceptionHandler(SessionNotFound::class)
    fun handleRSessionNotFound(e: SessionNotFound): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Session Not Found",
                message = e.message ?: "Session Not Found",
                status = HttpStatus.NOT_FOUND
            )
        )
    }

    @ExceptionHandler(RateCreateError::class)
    fun handleRateCreateError(e: RateCreateError): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Rate Create Error",
                message = e.message ?: "Rate Create Error",
                status = HttpStatus.BAD_REQUEST
            )
        )
    }

    @ExceptionHandler(SessionCreateError::class)
    fun handleSessionCreateError(e: SessionCreateError): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Session Create Error",
                message = e.message ?: "Session Create Error",
                status = HttpStatus.BAD_REQUEST
            )
        )
    }

    @ExceptionHandler(MissingRequestValueException::class)
    fun handleMissingRequestValueException(e: MissingRequestValueException): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Missing Request Value",
                message = e.message,
                status = HttpStatus.BAD_REQUEST
            )
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<ApiError> {
        return buildResponseEntity(
            ApiError(
                error = "Internal server error",
                message = e.message ?: "An unexpected error occurred",
                status = HttpStatus.INTERNAL_SERVER_ERROR
            )
        )
    }

    fun buildResponseEntity(apiError: ApiError): ResponseEntity<ApiError> {
        return ResponseEntity(apiError, apiError.status)
    }
}