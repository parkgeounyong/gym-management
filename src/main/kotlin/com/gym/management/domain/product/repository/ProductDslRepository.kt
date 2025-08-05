package com.gym.management.domain.product.repository

import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.entity.QProduct
import com.gym.management.domain.product.model.entity.QProductTemplate
import com.gym.management.domain.template.model.entity.QTemplate
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class ProductDslRepository(
    private val queryFactory: JPAQueryFactory,
) {
    fun findBy(branchId: Int, localDateTime: LocalDateTime): List<ProductDTO> {
        val product = QProduct.product
        val productTemplate = QProductTemplate.productTemplate
        val template = QTemplate.template

        //todo product는 상품 관리용도 및 기본값으로 사용하고 실제 데이터는 템플릿에 의존해서 사용하기
        //실제 사용 내용은 템플릿에서만 지정된다.
        //todo 기존 마스터 가지고 템플릿 생성시 템플릿 내용 + 상품 목록으로 생성되게 수정
        //템플릿에 존재하는 상품은 실 데이터를 삭제하는 형식으로 진행(데이터 전부 제거하고 생성)
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
}