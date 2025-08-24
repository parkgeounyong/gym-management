package com.gym.management.domain.branch.model.dto


data class ACreateBranchRequest(
    val branchName: String,
    val branchAddress: String,
    val userId: String,
    val branchBossUserId: String,
)
