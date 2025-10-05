package com.gym.management.domain.category.repository

import com.gym.management.common.utils.QuerydslUtils
import com.gym.management.domain.category.model.ProductCategoryDTOMapper.toDto
import com.gym.management.domain.category.model.dto.ProductCategoryDTO
import com.gym.management.domain.category.model.entity.ProductCategory
import com.gym.management.domain.category.model.entity.QProductCategory
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp

@Repository
class ProductCategoryRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
    private val namedJdbcTemplate: NamedParameterJdbcTemplate
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
        if (productCategoryList.isEmpty()) return

        val sql = """
            INSERT INTO gym_product_category (
                proca_code, branch_id, proca_name, 
                proca_created_at, proca_updated_at, 
                proca_deleted, user_id
            )
            VALUES (
                :procaCode, :branchId, :procaName, 
                :procaCreatedAt, :procaUpdatedAt, 
                :procaDeleted, :userId
            )
            ON CONFLICT (proca_code, branch_id)
            DO UPDATE SET 
                proca_name = EXCLUDED.proca_name,
                proca_updated_at = EXCLUDED.proca_updated_at,
                proca_deleted = EXCLUDED.proca_deleted,
                user_id = EXCLUDED.user_id
        """.trimIndent()

        val params = productCategoryList.map { category ->
            mutableMapOf<String, Any>().apply {
                this["procaCode"] = category.procaCode
                this["branchId"] = category.branchId
                this["procaName"] = category.procaName
                this["procaCreatedAt"] = Timestamp.valueOf(category.procaCreatedAt)
                this["procaUpdatedAt"] = Timestamp.valueOf(category.procaUpdatedAt)
                this["procaDeleted"] = category.procaDeleted.toString()
                this["userId"] = category.userId
            }
        }
        namedJdbcTemplate.batchUpdate(sql, params.toTypedArray())
    }
}