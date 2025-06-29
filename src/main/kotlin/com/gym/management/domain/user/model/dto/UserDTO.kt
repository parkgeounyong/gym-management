package com.gym.management.domain.user.model.dto

import com.gym.management.common.utils.UserUtils
import com.gym.management.domain.user.model.entity.User
import java.time.LocalDateTime

data class UserDTO(
    val userId: String,
    val userPassword: String,
    val userRole: String,
    val userName: String,
    val userPhone: String,
    val userEmail: String? = null,
    val userCreatedAt: LocalDateTime,
    val userUpdatedAt: LocalDateTime,
    val userDeleted: Boolean
) {
    constructor(user: User) : this(
        userId = user.userId,
        userPassword = user.userPassword,
        userRole = user.userRole,
        userName = user.userName,
        userPhone = user.userPhone,
        userEmail = user.userEmail,
        userCreatedAt = user.userCreatedAt,
        userUpdatedAt = user.userUpdatedAt,
        userDeleted = user.userDeleted
    )

    constructor(createUserRequest: CreateUserRequest) : this(
        userId = createUserRequest.userId,
        userPassword = UserUtils.hashSHA256(createUserRequest.userPassword),
        userRole = createUserRequest.userRole,
        userName = createUserRequest.userName,
        userPhone = createUserRequest.userPhone,
        userEmail = createUserRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = false
    )
}