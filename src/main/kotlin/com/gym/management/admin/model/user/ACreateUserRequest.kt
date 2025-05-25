package com.gym.management.admin.model.user

data class ACreateUserRequest(
    val userId: String,
    val userPassword: String,
    val userRole: String,//todo enum으로 처리
    val userName: String,
    val userPhone: String,
    val userEmail: String,
    val branchName: String,
    val branchAddress: String,
)