package com.gym.management.domain.branch.service

import com.gym.management.config.exception.custom.branch.BranchNotFoundException
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.model.entity.Branch
import com.gym.management.domain.branch.repository.BranchRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BranchService(
    private val branchRepository: BranchRepository
) {
    fun createBranch(branchDTO: BranchDTO): BranchDTO {
        val result = branchRepository.save(Branch(branchDTO))
        return BranchDTO(result)
    }

    @Transactional
    fun updateBranch(branchDTO: BranchDTO): BranchDTO {
        val result = branchRepository.findById(branchDTO.branchId)
            .orElseThrow { BranchNotFoundException() }
            .updateBy(branchDTO)
        return BranchDTO(result)
    }
}