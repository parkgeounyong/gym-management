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
    constructor(dCreateUserRequest: DCreateUserRequest) : this(
        userId = dCreateUserRequest.userId,
        userPassword = UserUtils.hashSHA256(dCreateUserRequest.userPassword),
        userRole = dCreateUserRequest.userRole,
        userName = dCreateUserRequest.userName,
        userPhone = dCreateUserRequest.userPhone,
        userEmail = dCreateUserRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = 'N'
    )

    constructor(dUpdateUserRequest: DUpdateUserRequest) : this(
        userId = dUpdateUserRequest.userId,
        userPassword = UserUtils.hashSHA256(dUpdateUserRequest.userPassword),
        userRole = dUpdateUserRequest.userRole,
        userName = dUpdateUserRequest.userName,
        userPhone = dUpdateUserRequest.userPhone,
        userEmail = dUpdateUserRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = 'N'
    )
}