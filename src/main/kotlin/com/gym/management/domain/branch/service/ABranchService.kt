package com.gym.management.domain.branch.service

import com.gym.management.domain.branch.model.dto.ACreateBranchRequest
import com.gym.management.domain.branch.model.dto.AUpdateBranchRequest
import com.gym.management.domain.branch.model.dto.BranchDTO
import org.springframework.stereotype.Service

@Service
class ABranchService(
    private val branchService: BranchService
) {
    fun createBranch(aCreateBranchRequest: ACreateBranchRequest): BranchDTO =
        branchService.createBranch(BranchDTO(aCreateBranchRequest))

    fun updateBranch(aUpdateBranchRequest: AUpdateBranchRequest): BranchDTO =
        branchService.updateBranch(BranchDTO(aUpdateBranchRequest))
}