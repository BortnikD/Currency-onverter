package org.bortnik.converter.domain.exceptions.session

class SessionCreateError: Exception {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)
}