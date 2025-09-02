package com.gym.management.domain.branch.service

import com.gym.management.config.exception.custom.branch.BranchNotFoundException
import com.gym.management.domain.branch.model.BranchMapper.toDto
import com.gym.management.domain.branch.model.BranchMapper.toEntity
import com.gym.management.domain.branch.model.BranchMapper.update
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.repository.BranchRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BranchService(
    private val branchRepository: BranchRepository
) {
    fun createBranch(branchDTO: BranchDTO): BranchDTO {
        return branchRepository.save(branchDTO.toEntity())
            .toDto()
    }

    @Transactional
    fun updateBranch(branchDTO: BranchDTO): BranchDTO {
        return branchRepository.findById(branchDTO.branchId)
            .orElseThrow { BranchNotFoundException() }
            .update(branchDTO)
            .toDto()
    }
}