package com.gym.management.common.model.user.dto

import com.gym.management.admin.model.user.ACreateUserRequest
import com.gym.management.common.UserUtils
import com.gym.management.common.model.user.entity.User
import com.gym.management.device.model.DCreateUserRequest
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
    val userDeleted: Boolean = false
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

    constructor(aCreateUserRequest: ACreateUserRequest): this(
        userId = aCreateUserRequest.userId,
        userPassword = UserUtils.hashSHA256(aCreateUserRequest.userPassword),
        userRole = aCreateUserRequest.userRole,
        userName = aCreateUserRequest.userName,
        userPhone = aCreateUserRequest.userPhone,
        userEmail = aCreateUserRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = false
    )

    constructor(dCreateUserRequest: DCreateUserRequest): this(
        userId = dCreateUserRequest.userId,
        userPassword = UserUtils.hashSHA256(dCreateUserRequest.userPassword),
        userRole = dCreateUserRequest.userRole,
        userName = dCreateUserRequest.userName,
        userPhone = dCreateUserRequest.userPhone,
        userEmail = dCreateUserRequest.userEmail,
        userCreatedAt = LocalDateTime.now(),
        userUpdatedAt = LocalDateTime.now(),
        userDeleted = false
    )
}