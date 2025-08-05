package com.gym.management.domain.product.service

import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.entity.Product
import com.gym.management.domain.product.model.entity.ProductTemplate
import com.gym.management.domain.product.model.entity.id.ProductId
import com.gym.management.domain.product.repository.ProductDslRepository
import com.gym.management.domain.product.repository.ProductTemplateRepository
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class DProductService(
    private val productRepository: ProductRepository,
    private val entityManager: EntityManager,
    private val productTemplateRepository: ProductTemplateRepository,
    private val productDslRepository: ProductDslRepository
) {
    fun createProduct(productDTO: ProductDTO): ProductDTO {
        val result = productRepository.save(Product(productDTO))
        return ProductDTO(result)
    }

    @Transactional
    fun upsertProduct(productList: List<ProductDTO>): Boolean {
        val idList = productList.map { ProductId(it.branchId, it.productCode) }
        val existingEntities =
            productRepository.findAllById(idList).associateBy { ProductId(it.branchId, it.productCode) }

        val toInsert = mutableListOf<Product>()

        productList.forEach { dto ->
            val key = ProductId(dto.branchId, dto.productCode)
            val entity = existingEntities[key]
            if (entity != null) {
                entity.updateBy(dto)
            } else {
                toInsert.add(Product(dto))
            }
        }

        toInsert.forEachIndexed { index, entity ->
            entityManager.persist(entity)
            if (index % 100 == 0) {
                entityManager.flush()
                entityManager.clear()
            }
        }
        return true
    }

    fun findBy(branchId: Int, localDateTime: LocalDateTime): List<ProductDTO> {
        return productDslRepository.findBy(branchId, localDateTime)
    }

    fun createProductTemplates(productTemplateDTO: ProductTemplateDTO): ProductTemplateDTO {
        val result = productTemplateRepository.save(ProductTemplate(productTemplateDTO))
        return ProductTemplateDTO(result)
    }
}