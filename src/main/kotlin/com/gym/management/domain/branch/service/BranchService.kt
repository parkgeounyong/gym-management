package com.gym.management.domain.branch.service

import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.model.entity.Branch
import com.gym.management.domain.branch.repository.BranchRepository
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