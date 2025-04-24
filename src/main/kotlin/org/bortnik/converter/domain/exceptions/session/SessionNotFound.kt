package org.bortnik.converter.domain.exceptions.session

class SessionNotFound: Exception {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)
}