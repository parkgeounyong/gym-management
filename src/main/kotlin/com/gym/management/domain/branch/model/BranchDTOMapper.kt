package com.gym.management.domain.branch.model

import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.model.entity.Branch
import com.gym.management.domain.branch.model.request.ACreateBranchRequest
import com.gym.management.domain.branch.model.request.AUpdateBranchRequest
import com.gym.management.domain.user.model.request.DCreateUserRequest
import com.gym.management.domain.user.model.request.DUpdateUserRequest
import java.time.LocalDateTime

object BranchDTOMapper {
    fun Branch.toDto(): BranchDTO = BranchDTO(
        branchId = this.branchId,
        branchName = this.branchName,
        branchAddress = this.branchAddress,
        branchCreatedAt = this.branchCreatedAt,
        branchUpdatedAt = this.branchUpdatedAt,
        branchDeleted = this.branchDeleted,
        userId = this.userId,
        branchBossUserId = this.branchBossUserId,
    )

    fun DCreateUserRequest.toBranchDto(): BranchDTO =
        BranchDTO(
            branchId = 0,
            branchName = this.branchName,
            branchAddress = this.branchAddress,
            branchCreatedAt = LocalDateTime.now(),
            branchUpdatedAt = LocalDateTime.now(),
            branchDeleted = 'N',
            userId = this.userId,
            branchBossUserId = this.userId,
        )

    fun DUpdateUserRequest.toBranchDto(): BranchDTO =
        BranchDTO(
            branchId = this.branchId,
            branchName = this.branchName,
            branchAddress = this.branchAddress,
            branchCreatedAt = LocalDateTime.now(),
            branchUpdatedAt = LocalDateTime.now(),
            branchDeleted = 'N',
            userId = this.userId,
            branchBossUserId = this.userId,
        )

    fun ACreateBranchRequest.toBranchDto(): BranchDTO =
        BranchDTO(
            branchId = 0,
            branchName = this.branchName,
            branchAddress = this.branchAddress,
            branchCreatedAt = LocalDateTime.now(),
            branchUpdatedAt = LocalDateTime.now(),
            branchDeleted = 'N',
            userId = this.userId,
            branchBossUserId = this.userId,
        )

    fun AUpdateBranchRequest.toBranchDto(): BranchDTO =
        BranchDTO(
            branchId = this.branchId,
            branchName = this.branchName,
            branchAddress = this.branchAddress,
            branchUpdatedAt = LocalDateTime.now(),
            branchDeleted = this.branchDeleted,
            userId = this.userId,
            branchBossUserId = this.userId,
        )
}