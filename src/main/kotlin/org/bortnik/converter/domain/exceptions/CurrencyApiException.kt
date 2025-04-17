package org.bortnik.converter.domain.exceptions

class CurrencyApiException: Exception {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)
}