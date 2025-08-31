package com.gym.management.domain.branch.model.dto

import java.time.LocalDateTime

data class BranchDTO(
    val branchId: Int = 0,
    val branchName: String,
    val branchAddress: String,
    val branchCreatedAt: LocalDateTime = LocalDateTime.now(),
    val branchUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val branchDeleted: Char = 'N',
    val userId: String,
    val branchBossUserId: String,
)