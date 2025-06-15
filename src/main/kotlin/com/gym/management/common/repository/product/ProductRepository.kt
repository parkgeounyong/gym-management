package com.gym.management.common.repository.product

import com.gym.management.common.model.product.entity.Product
import com.gym.management.common.model.product.entity.id.ProductId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, ProductId>