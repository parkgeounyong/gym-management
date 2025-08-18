package com.gym.management.domain.product.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.service.AProductService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Product")
class AProductController(
    private val aProductService: AProductService
) {
    @PostMapping("/admin/product-templates")
    fun createProductTemplates(
        @RequestBody productTemplateDTO: ProductTemplateDTO
    ): ApiResponse<ProductTemplateDTO> {
        return ApiResponse(
            data = aProductService.createProductTemplates(productTemplateDTO)
        )
    }

    @PutMapping("/admin/product-templates")
    fun updateProductTemplates(
        @RequestBody productTemplateDTO: ProductTemplateDTO
    ): ApiResponse<ProductTemplateDTO> {
        return ApiResponse(
            data = aProductService.updateProductTemplates(productTemplateDTO)
        )
    }
}