package com.gym.management.config.exception.custom

open class CustomException(
    message: String,
    val code: String = "E998",
) : RuntimeException(message)