package com.gym.management.common.model.util

data class ApiResponse<T>(
    val code: String = "C000",
    val errorMessage: String? = null,
    val data: T? = null
)