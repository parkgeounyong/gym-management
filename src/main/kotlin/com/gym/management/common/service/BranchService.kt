package com.gym.management.common.service

import com.gym.management.common.model.branch.dto.BranchDTO
import com.gym.management.common.model.branch.entity.Branch
import com.gym.management.common.repository.branch.BranchRepository
import org.springframework.stereotype.Service

@Service
class BranchService(
    private val branchRepository: BranchRepository
) {
    fun createBranch(branchDTO: BranchDTO): BranchDTO {
        val result = branchRepository.save(Branch(branchDTO))
        return BranchDTO(result)
    }
}