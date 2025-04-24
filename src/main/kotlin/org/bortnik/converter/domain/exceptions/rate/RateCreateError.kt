package org.bortnik.converter.domain.exceptions.rate

class RateCreateError: Exception {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)
}