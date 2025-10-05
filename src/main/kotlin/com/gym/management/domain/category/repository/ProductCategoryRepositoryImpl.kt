package com.gym.management.domain.category.repository

import com.gym.management.common.utils.QuerydslUtils
import com.gym.management.domain.category.model.ProductCategoryDTOMapper.toDto
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.entity.QProductCategory
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp

@Repository
class ProductCategoryRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
    private val jdbcTemplate: JdbcTemplate
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

    @Transactional
    override fun bulkUpsertProductCategory(productCategoryList: List<ProductCategory>) {
        if (productCategoryList.isEmpty()) {
            return
        }

        val sql = """
            INSERT INTO gym_product_category (
                proca_code, branch_id, proca_name, 
                proca_created_at, proca_updated_at, 
                proca_deleted, user_id
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
            ON CONFLICT (proca_code, branch_id)
            DO UPDATE SET 
                proca_name = EXCLUDED.proca_name,
                proca_updated_at = EXCLUDED.proca_updated_at,
                proca_deleted = EXCLUDED.proca_deleted,
                user_id = EXCLUDED.user_id
        """.trimIndent()


        jdbcTemplate.batchUpdate(sql, productCategoryList, 1000) { ps, productCategory ->
            ps.setString(1, productCategory.procaCode)
            ps.setInt(2, productCategory.branchId)
            ps.setString(3, productCategory.procaName)
            ps.setTimestamp(4, Timestamp.valueOf(productCategory.procaCreatedAt))
            ps.setTimestamp(5, Timestamp.valueOf(productCategory.procaUpdatedAt))
            ps.setString(6, productCategory.procaDeleted.toString())
            ps.setString(7, productCategory.userId)
        }
    }
}