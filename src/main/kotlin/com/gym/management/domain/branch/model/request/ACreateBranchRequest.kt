package com.gym.management.domain.branch.model.request


data class ACreateBranchRequest(
    val branchName: String,
    val branchAddress: String,
    val userId: String,
    val branchBossUserId: String,
)
