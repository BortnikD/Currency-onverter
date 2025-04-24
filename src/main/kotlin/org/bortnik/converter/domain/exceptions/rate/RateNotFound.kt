package org.bortnik.converter.domain.exceptions.rate

class RateNotFound: Exception {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message)
}