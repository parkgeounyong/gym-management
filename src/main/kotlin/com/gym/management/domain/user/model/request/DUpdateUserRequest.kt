package com.gym.management.domain.user.model.request

data class DUpdateUserRequest(
    val userId: String,
    val userPassword: String,
    val userRole: String,
    val userName: String,
    val userPhone: String,
    val userEmail: String? = null,
    val branchId: Int,
    val branchName: String,
    val branchAddress: String,
)