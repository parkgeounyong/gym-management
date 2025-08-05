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
    constructor(userUpsertRequest: UserUpsertRequest) : this(
        userId = userUpsertRequest.userId,
        userPassword = UserUtils.hashSHA256(userUpsertRequest.userPassword),
        userRole = userUpsertRequest.userRole,
        userName = userUpsertRequest.userName,
        userPhone = userUpsertRequest.userPhone,
        userEmail = userUpsertRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = 'N'
    )
}