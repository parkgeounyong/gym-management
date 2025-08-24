package com.gym.management.domain.product.repository

import com.gym.management.domain.product.model.entity.Product
import com.gym.management.domain.product.model.entity.id.ProductId
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, ProductId>, ProductRepositoryCustom {
}