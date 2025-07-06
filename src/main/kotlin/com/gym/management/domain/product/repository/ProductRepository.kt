package com.gym.management.domain.product.repository

import com.gym.management.domain.product.model.entity.Product
import com.gym.management.domain.product.model.entity.id.ProductId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, ProductId> {
    fun findByBranchId(branchId: Int): List<Product>
}