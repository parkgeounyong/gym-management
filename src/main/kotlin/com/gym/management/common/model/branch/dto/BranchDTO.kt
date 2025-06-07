package com.gym.management.common.model.branch.dto

import com.gym.management.admin.model.user.ACreateUserRequest
import com.gym.management.common.model.branch.entity.Branch
import com.gym.management.device.model.user.DCreateUserRequest
import java.time.LocalDateTime

data class BranchDTO(
    val id: Int = 0,
    val branchName: String,
    val branchAddress: String,
    val branchCreatedAt: LocalDateTime,
    val branchUpdatedAt: LocalDateTime,
    val branchDeleted: Boolean = false
) {
    constructor(branch: Branch) : this(
        id = branch.id,
        branchName = branch.branchName,
        branchAddress = branch.branchAddress,
        branchCreatedAt = branch.branchCreatedAt,
        branchUpdatedAt = branch.branchUpdatedAt,
        branchDeleted = branch.branchDeleted
    )

    constructor(aCreateUserRequest: ACreateUserRequest) : this(
        branchName = aCreateUserRequest.branchName,
        branchAddress = aCreateUserRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = false
    )

    constructor(dCreateUserRequest: DCreateUserRequest) : this(
        branchName = dCreateUserRequest.branchName,
        branchAddress = dCreateUserRequest.branchAddress,
        branchCreatedAt = LocalDateTime.now(),
        branchUpdatedAt = LocalDateTime.now(),
        branchDeleted = false
    )
}