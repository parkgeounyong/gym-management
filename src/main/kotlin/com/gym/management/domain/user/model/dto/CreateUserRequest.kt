package com.gym.management.domain.user.model.dto

import java.time.LocalDateTime

data class CreateUserRequest(
    val userId: String,
    val userPassword: String,
    val userRole: String,
    val userName: String,
    val userPhone: String,
    val userEmail: String? = null,
    val userCreatedAt: LocalDateTime = LocalDateTime.now(),
    val userUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val userDeleted: Boolean = false,
    val branchName: String,
    val branchAddress: String,
)