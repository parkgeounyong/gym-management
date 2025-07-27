package com.gym.management.domain.branch.model.dto

import com.gym.management.domain.branch.model.entity.Branch
import com.gym.management.domain.user.model.dto.CreateUserRequest
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

    constructor(createUserRequest: CreateUserRequest) : this(
        id = 0,
        branchName = createUserRequest.branchName,
        branchAddress = createUserRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = 'N',
        userId = createUserRequest.userId
    )
}