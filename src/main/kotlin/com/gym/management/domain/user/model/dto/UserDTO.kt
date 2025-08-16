package com.gym.management.domain.user.model.dto

import com.gym.management.common.utils.UserUtils
import java.time.LocalDateTime

data class UserDTO(
    val userId: String,
    val userPassword: String,
    val userRole: String,
    val userName: String,
    val userPhone: String,
    val userEmail: String? = null,
    val userCreatedAt: LocalDateTime = LocalDateTime.now(),
    val userUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val userDeleted: Char = 'N'
) {
    constructor(userRequest: UserRequest) : this(
        userId = userRequest.userId,
        userPassword = UserUtils.hashSHA256(userRequest.userPassword),
        userRole = userRequest.userRole,
        userName = userRequest.userName,
        userPhone = userRequest.userPhone,
        userEmail = userRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = 'N'
    )
}