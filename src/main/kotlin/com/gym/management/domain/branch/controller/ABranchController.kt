package com.gym.management.domain.branch.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.common.model.PageResponse
import com.gym.management.domain.branch.model.dto.ACreateBranchRequest
import com.gym.management.domain.branch.model.dto.AUpdateBranchRequest
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.service.ABranchService
import org.springframework.web.bind.annotation.*

@RestController
class ABranchController(
    private val aBranchService: ABranchService
) {
    @PostMapping("/admin/branches")
    fun createBranch(
        @RequestBody aCreateBranchRequest: ACreateBranchRequest
    ): ApiResponse<BranchDTO> {
        return ApiResponse(data = aBranchService.createBranch(aCreateBranchRequest))
    }

    @PutMapping("/admin/branches")
    fun updateBranch(
        @RequestBody aUpdateBranchRequest: AUpdateBranchRequest
    ): ApiResponse<BranchDTO> {
        return ApiResponse(data = aBranchService.updateBranch(aUpdateBranchRequest))
    }

    @GetMapping("/admin/branches")
    fun fetchBranches(
        @RequestParam branchId: Int? = null,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @RequestParam sortBy: String,
        @RequestParam direction: String
    ): ApiResponse<PageResponse<BranchDTO>> {
        return ApiResponse(data = aBranchService.fetchBranches(branchId, page, size, sortBy, direction))
    }
}