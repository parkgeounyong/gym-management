package com.gym.management.domain.user.model.dto

data class UserUpsertRequest(
    val userId: String,
    val userPassword: String,
    val userRole: String,
    val userName: String,
    val userPhone: String,
    val userEmail: String? = null,
    val branchName: String,
    val branchAddress: String,
)