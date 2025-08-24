package com.gym.management.domain.branch.model.dto

import com.gym.management.domain.branch.model.entity.Branch
import com.gym.management.domain.user.model.dto.DCreateUserRequest
import com.gym.management.domain.user.model.dto.DUpdateUserRequest
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

    constructor(dCreateUserRequest: DCreateUserRequest) : this(
        branchId = 0,
        branchName = dCreateUserRequest.branchName,
        branchAddress = dCreateUserRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = 'N',
        userId = dCreateUserRequest.userId,
        branchBossUserId = dCreateUserRequest.userId,
    )

    constructor(dUpdateUserRequest: DUpdateUserRequest) : this(
        branchId = dUpdateUserRequest.branchId,
        branchName = dUpdateUserRequest.branchName,
        branchAddress = dUpdateUserRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = 'N',
        userId = dUpdateUserRequest.userId,
        branchBossUserId = dUpdateUserRequest.userId,
    )

    constructor(aCreateBranchRequest: ACreateBranchRequest) : this(
        branchId = 0,
        branchName = aCreateBranchRequest.branchName,
        branchAddress = aCreateBranchRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = 'N',
        userId = aCreateBranchRequest.userId,
        branchBossUserId = aCreateBranchRequest.userId,
    )

    constructor(aUpdateBranchRequest: AUpdateBranchRequest) : this(
        branchId = aUpdateBranchRequest.branchId,
        branchName = aUpdateBranchRequest.branchName,
        branchAddress = aUpdateBranchRequest.branchAddress,
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = aUpdateBranchRequest.branchDeleted,
        userId = aUpdateBranchRequest.userId,
        branchBossUserId = aUpdateBranchRequest.userId,
    )
}