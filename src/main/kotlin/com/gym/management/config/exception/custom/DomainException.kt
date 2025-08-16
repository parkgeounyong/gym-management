package com.gym.management.config.exception.custom

open class DomainException(
    message: String,
    val code: String = "E998",
) : RuntimeException(message)