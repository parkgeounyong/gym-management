package com.gym.management.domain.product.service

import com.gym.management.domain.product.model.ProductMapper.toDto
import com.gym.management.domain.product.model.ProductMapper.toEntity
import com.gym.management.domain.product.model.ProductMapper.update
import com.gym.management.domain.product.repository.ProductRepository
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.entity.Product
import com.gym.management.domain.product.model.entity.id.ProductId
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class DProductService(
    private val productRepository: ProductRepository,
    private val entityManager: EntityManager,
) {
    fun createProduct(productDTO: ProductDTO): ProductDTO {
        return productRepository.save(productDTO.toEntity())
            .toDto()
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
                entity.update(dto)
            } else {
                toInsert.add(dto.toEntity())
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
        return productRepository.findBy(branchId, localDateTime)
    }
}