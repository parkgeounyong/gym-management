package com.gym.management.domain.product.repository

import com.gym.management.common.utils.QuerydslUtils
import com.gym.management.domain.product.model.ProductMapper.toDto
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.entity.Product
import com.gym.management.domain.product.model.entity.QProduct
import com.gym.management.domain.product.model.entity.QProductTemplate
import com.gym.management.domain.template.model.entity.QTemplate
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp
import java.time.LocalDateTime

@Repository
class ProductRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
    private val jdbcTemplate: JdbcTemplate
) : ProductRepositoryCustom {
    override fun findBy(branchId: Int, localDateTime: LocalDateTime): List<ProductDTO> {
        val product = QProduct.product
        val productTemplate = QProductTemplate.productTemplate
        val template = QTemplate.template

        return queryFactory.select(
            template.templatePriority,
            productTemplate.branchId,
            productTemplate.productCode,
            product.procaCode,
            productTemplate.proteName,
            productTemplate.protePrice,
            productTemplate.proteCreatedAt,
            productTemplate.proteUpdatedAt,
            productTemplate.proteDeleted,
            product.userId
        ).from(productTemplate).join(template).on(
            productTemplate.branchId.eq(template.branchId),
            productTemplate.templateCode.eq(template.templateCode)
        ).join(product).on(
            product.branchId.eq(productTemplate.branchId),
            product.productCode.eq(product.productCode)
        ).where(
            product.branchId.eq(branchId),
            template.templateStartAt.loe(localDateTime),
            template.templateEndAt.goe(localDateTime),
            template.templateDeleted.eq('N')
        ).fetch()
            .groupBy { it.get(product.productCode) }
            .mapValues { (_, list) -> list.minByOrNull { it.get(template.templatePriority)!! } }.values.filterNotNull()
            .map { tuple ->
                ProductDTO(
                    branchId = tuple.get(productTemplate.branchId)!!,
                    productCode = tuple.get(productTemplate.productCode)!!,
                    productCategoryCode = tuple.get(product.procaCode)!!,
                    productName = tuple.get(productTemplate.proteName)!!,
                    productPrice = tuple.get(productTemplate.protePrice)!!,
                    productCreatedAt = tuple.get(productTemplate.proteCreatedAt)!!,
                    productUpdatedAt = tuple.get(productTemplate.proteUpdatedAt)!!,
                    productDeleted = tuple.get(productTemplate.proteDeleted)!!,
                    userId = tuple.get(product.userId)!!,
                )
            }
    }

    override fun countProduct(branchId: Int?): Int {
        val product = QProduct.product
        return queryFactory
            .select(product.count())
            .from(product)
            .where(QuerydslUtils.buildEqualsIfPresent(product.branchId, branchId))
            .fetchOne()?.toInt() ?: 0
    }

    override fun fetchProduct(
        branchId: Int?,
        page: Int,
        size: Int,
        sortBy: String,
        direction: String
    ): List<ProductDTO> {
        val product = QProduct.product

        return queryFactory.select(product)
            .from(product)
            .where(QuerydslUtils.buildEqualsIfPresent(product.branchId, branchId))
            .orderBy(QuerydslUtils.createSort(product, sortBy, direction))
            .offset((page - 1) * size.toLong())
            .limit(size.toLong())
            .fetch()
            .map { it.toDto() }
    }

    @Transactional
    override fun bulkUpsertProduct(productList: List<Product>) {
        if (productList.isEmpty()) {
            return
        }

        val sql = """
            INSERT INTO gym_product (
                branch_id, product_code, proca_code, product_name, 
                product_price, product_created_at, product_updated_at, 
                product_deleted, user_id
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            ON CONFLICT (branch_id, product_code)
            DO UPDATE SET 
                proca_code = EXCLUDED.proca_code,
                product_name = EXCLUDED.product_name,
                product_price = EXCLUDED.product_price,
                product_updated_at = EXCLUDED.product_updated_at,
                product_deleted = EXCLUDED.product_deleted,
                user_id = EXCLUDED.user_id
        """.trimIndent()

        jdbcTemplate.batchUpdate(sql, productList, 1000) { ps, product ->
            ps.setInt(1, product.branchId)
            ps.setString(2, product.productCode)
            ps.setString(3, product.procaCode)
            ps.setString(4, product.productName)
            ps.setBigDecimal(5, product.productPrice)
            ps.setTimestamp(6, Timestamp.valueOf(product.productCreatedAt))
            ps.setTimestamp(7, Timestamp.valueOf(product.productUpdatedAt))
            ps.setString(8, product.productDeleted.toString())
            ps.setString(9, product.userId)
        }
    }
}