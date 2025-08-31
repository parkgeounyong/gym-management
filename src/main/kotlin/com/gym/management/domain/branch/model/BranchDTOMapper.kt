package com.gym.management.domain.branch.model

import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.model.request.ACreateBranchRequest
import com.gym.management.domain.branch.model.request.AUpdateBranchRequest
import com.gym.management.domain.user.model.request.DCreateUserRequest
import com.gym.management.domain.user.model.request.DUpdateUserRequest
import java.time.LocalDateTime

object BranchDTOMapper {
    fun DCreateUserRequest.toBranchDTO(): BranchDTO =
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

    fun DUpdateUserRequest.toBranchDTO(): BranchDTO =
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

    fun ACreateBranchRequest.toBranchDTO(): BranchDTO =
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

    fun AUpdateBranchRequest.toBranchDTO(): BranchDTO =
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