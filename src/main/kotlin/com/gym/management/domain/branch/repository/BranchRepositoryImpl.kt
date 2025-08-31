package com.gym.management.domain.branch.repository

import com.gym.management.common.utils.QuerydslUtils
import com.gym.management.domain.branch.model.BranchMapper.toDto
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.model.entity.QBranch
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class BranchRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : BranchRepositoryCustom {
    override fun countBranches(branchId: Int?): Int {
        val branch = QBranch.branch
        return queryFactory
            .select(branch.count())
            .from(branch)
            .where(QuerydslUtils.buildEqualsIfPresent(branch.branchId, branchId))
            .fetchOne()?.toInt() ?: 0
    }

    override fun fetchBranches(
        branchId: Int?,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<BranchDTO> {
        val branch = QBranch.branch

        return queryFactory.select(branch)
            .from(branch)
            .where(QuerydslUtils.buildEqualsIfPresent(branch.branchId, branchId))
            .orderBy(QuerydslUtils.createSort(branch, sortBy, direction))
            .offset((page - 1) * size.toLong())
            .limit(size.toLong())
            .fetch()
            .map { it.toDto() }
    }
}