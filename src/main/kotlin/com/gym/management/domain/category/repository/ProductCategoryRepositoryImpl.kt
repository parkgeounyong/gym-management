package com.gym.management.domain.category.repository

import com.gym.management.common.utils.QuerydslUtils
import com.gym.management.domain.category.model.ProductCategoryMapper.toDto
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.QProductCategory
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ProductCategoryRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : ProductCategoryRepositoryCustom {
    override fun countProductCategory(branchId: Int?): Int {
        val pc = QProductCategory.productCategory
        return queryFactory
            .select(pc.count())
            .from(pc)
            .where(QuerydslUtils.buildEqualsIfPresent(pc.branchId, branchId))
            .fetchOne()?.toInt() ?: 0
    }

    override fun fetchProductCategory(
        branchId: Int?,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<ProductCategoryDTO> {
        val pc = QProductCategory.productCategory

        return queryFactory.select(pc)
            .from(pc)
            .where(QuerydslUtils.buildEqualsIfPresent(pc.branchId, branchId))
            .orderBy(QuerydslUtils.createSort(pc, sortBy, direction))
            .offset((page - 1) * size.toLong())
            .limit(size.toLong())
            .fetch()
            .map { it.toDto() }
    }
}