package org.bortnik.converter.api.http

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ApiError(
    val error: String,
    val message: String,
    val status: HttpStatus,
    val timestamp: LocalDateTime = LocalDateTime.now()
)