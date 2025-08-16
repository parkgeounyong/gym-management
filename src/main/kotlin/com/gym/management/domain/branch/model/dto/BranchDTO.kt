package com.gym.management.domain.branch.model.dto

import com.gym.management.domain.branch.model.entity.Branch
import com.gym.management.domain.user.model.dto.UserRequest
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
) {
    constructor(branch: Branch) : this(
        branchId = branch.branchId,
        branchName = branch.branchName,
        branchAddress = branch.branchAddress,
        branchCreatedAt = branch.branchCreatedAt,
        branchUpdatedAt = branch.branchUpdatedAt,
        branchDeleted = branch.branchDeleted,
        userId = branch.userId,
        branchBossUserId = branch.branchBossUserId,
    )

    constructor(userRequest: UserRequest) : this(
        branchId = 0,
        branchName = userRequest.branchName,
        branchAddress = userRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = 'N',
        userId = userRequest.userId,
        branchBossUserId = userRequest.userId,
    )
}