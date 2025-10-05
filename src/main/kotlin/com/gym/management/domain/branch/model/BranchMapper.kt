package com.gym.management.domain.branch.model

import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.model.entity.Branch
import java.time.LocalDateTime

object BranchMapper {
    fun BranchDTO.toEntity(): Branch =
        Branch(
            branchName = this.branchName,
            branchAddress = this.branchAddress,
            branchCreatedAt = LocalDateTime.now(),
            branchUpdatedAt = LocalDateTime.now(),
            branchDeleted = 'N',
            userId = this.userId,
            branchBossUserId = this.branchBossUserId,
        )

    fun Branch.update(branchDTO: BranchDTO): Branch {
        branchName = branchDTO.branchName
        branchAddress = branchDTO.branchAddress
        branchUpdatedAt = LocalDateTime.now()
        userId = branchDTO.userId
        branchBossUserId = branchDTO.branchBossUserId
        return this
    }
}