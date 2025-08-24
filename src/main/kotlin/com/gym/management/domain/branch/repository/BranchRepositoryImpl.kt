package com.gym.management.domain.branch.repository

import com.gym.management.common.utils.PageUtils
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.branch.model.entity.QBranch
import com.querydsl.core.BooleanBuilder
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
            .where(buildBranchPagesCondition(branchId))
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
            .where(buildBranchPagesCondition(branchId))
            .orderBy(PageUtils.createSort(branch, sortBy, direction))
            .offset((page - 1) * size.toLong())
            .limit(size.toLong())
            .fetch()
            .map { BranchDTO(it) }
    }

    private fun buildBranchPagesCondition(branchId: Int? = null): BooleanBuilder {
        return BooleanBuilder().apply {
            branchId?.let { and(QBranch.branch.branchId.eq(it)) }
        }
    }
}