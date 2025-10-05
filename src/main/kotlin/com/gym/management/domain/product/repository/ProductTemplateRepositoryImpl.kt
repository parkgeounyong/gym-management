package com.gym.management.domain.product.repository

import com.gym.management.common.utils.QuerydslUtils
import com.gym.management.domain.product.model.ProductTemplateDTOMapper.toDto
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.QProductTemplate
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ProductTemplateRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : ProductTemplateRepositoryCustom {
    override fun countProductTemplate(branchId: Int?, templateCode: String?): Int {
        val pt = QProductTemplate.productTemplate
        return queryFactory
            .select(pt.count())
            .from(pt)
            .where(
                QuerydslUtils.buildEqualsIfPresent(pt.branchId, branchId),
                QuerydslUtils.buildEqualsIfPresent(pt.templateCode, templateCode)
            )
            .fetchOne()?.toInt() ?: 0
    }

    override fun fetchProductTemplate(
        branchId: Int?,
        templateCode: String?,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<ProductTemplateDTO> {
        val pt = QProductTemplate.productTemplate

        return queryFactory.select(pt)
            .from(pt)
            .where(
                QuerydslUtils.buildEqualsIfPresent(pt.branchId, branchId),
                QuerydslUtils.buildEqualsIfPresent(pt.templateCode, templateCode)
            ).orderBy(QuerydslUtils.createSort(pt, sortBy, direction))
            .offset((page - 1) * size.toLong())
            .limit(size.toLong())
            .fetch()
            .map { it.toDto() }
    }
}