package com.gym.management.common.service

import com.gym.management.common.repository.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {

}