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
    constructor(createUserRequest: CreateUserRequest) : this(
        userId = createUserRequest.userId,
        userPassword = UserUtils.hashSHA256(createUserRequest.userPassword),
        userRole = createUserRequest.userRole,
        userName = createUserRequest.userName,
        userPhone = createUserRequest.userPhone,
        userEmail = createUserRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = 'N'
    )
}