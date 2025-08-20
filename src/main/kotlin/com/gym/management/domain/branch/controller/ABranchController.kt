package com.gym.management.domain.branch.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.service.BranchService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ABranchController(
    private val branchService: BranchService
) {
    @PostMapping("/admin/branches")
    fun createBranch(
        @RequestBody branchDTO: BranchDTO
    ): ApiResponse<BranchDTO> {
        return ApiResponse(data = branchService.createBranch(branchDTO))
    }

    @PutMapping("/admin/branches")
    fun updateBranch(
        @RequestBody branchDTO: BranchDTO
    ): ApiResponse<BranchDTO> {
        return ApiResponse(data = branchService.updateBranch(branchDTO))
    }
}