package com.gym.management.common.model.user.dto

import com.gym.management.device.model.user.DLoginFormRequest

data class LoginFormDTO(
    val userId: String,
    val password: String,
) {
    constructor(loginFormRequest: DLoginFormRequest) : this(
        userId = loginFormRequest.userId,
        password = loginFormRequest.password,
    )
}