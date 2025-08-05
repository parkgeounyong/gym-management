package com.gym.management.domain.branch.model.dto

import com.gym.management.domain.branch.model.entity.Branch
import com.gym.management.domain.user.model.dto.UserUpsertRequest
import java.time.LocalDateTime

data class BranchDTO(
    val id: Int = 0,
    val branchName: String,
    val branchAddress: String,
    val branchCreatedAt: LocalDateTime = LocalDateTime.now(),
    val branchUpdatedAt: LocalDateTime = LocalDateTime.now(),
    val branchDeleted: Char = 'N',
    val userId: String,
) {
    constructor(branch: Branch) : this(
        id = branch.id,
        branchName = branch.branchName,
        branchAddress = branch.branchAddress,
        branchCreatedAt = branch.branchCreatedAt,
        branchUpdatedAt = branch.branchUpdatedAt,
        branchDeleted = branch.branchDeleted,
        userId = branch.userId
    )

    constructor(userUpsertRequest: UserUpsertRequest) : this(
        id = 0,
        branchName = userUpsertRequest.branchName,
        branchAddress = userUpsertRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = 'N',
        userId = userUpsertRequest.userId
    )
}