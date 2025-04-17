package org.bortnik.converter.api.http

import java.time.LocalDateTime

data class ApiError(
    val message: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)