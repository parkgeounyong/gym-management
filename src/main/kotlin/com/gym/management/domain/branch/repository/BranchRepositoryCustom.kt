package com.gym.management.domain.branch.repository

import com.gym.management.domain.branch.model.dto.BranchDTO

interface BranchRepositoryCustom {
    fun countBranches(branchId: Int? = null): Int
    fun fetchBranches(
        branchId: Int? = null,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<BranchDTO>
}