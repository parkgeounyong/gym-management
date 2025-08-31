package com.gym.management.domain.branch.service

import com.gym.management.common.model.PageResponse
import com.gym.management.config.exception.custom.branch.BranchNotFoundException
import com.gym.management.domain.branch.model.BranchDTOMapper.toBranchDTO
import com.gym.management.domain.branch.model.BranchMapper.toDto
import com.gym.management.domain.branch.model.request.ACreateBranchRequest
import com.gym.management.domain.branch.model.request.AUpdateBranchRequest
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.repository.BranchRepository
import org.springframework.stereotype.Service

@Service
class ABranchService(
    private val branchService: BranchService,
    private val branchRepository: BranchRepository,
) {
    fun createBranch(aCreateBranchRequest: ACreateBranchRequest): BranchDTO =
        branchService.createBranch(aCreateBranchRequest.toBranchDTO())

    fun updateBranch(aUpdateBranchRequest: AUpdateBranchRequest): BranchDTO =
        branchService.updateBranch(aUpdateBranchRequest.toBranchDTO())

    fun fetchBranches(
        branchId: Int? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): PageResponse<BranchDTO> {
        val count = branchRepository.countBranches(branchId)
        val items = branchRepository.fetchBranches(branchId, page, size, sortBy, direction)
        return PageResponse(
            totalCount = count,
            totalPages = (count + size - 1) / size,
            page = page,
            size = size,
            sortBy = sortBy,
            direction = direction,
            items = items
        )
    }

    fun findBy(branchId: Int): BranchDTO {
        return branchRepository.findById(branchId).orElseThrow { BranchNotFoundException() }.toDto()
    }
}