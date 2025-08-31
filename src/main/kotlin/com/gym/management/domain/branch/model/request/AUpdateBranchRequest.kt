package com.gym.management.domain.branch.model.request

data class AUpdateBranchRequest(
    val branchId: Int,
    val branchName: String,
    val branchAddress: String,
    val branchDeleted: Char = 'N',
    val userId: String,
    val branchBossUserId: String,
)