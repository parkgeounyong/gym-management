package com.gym.management.domain.product.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.common.model.PageResponse
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
import com.gym.management.domain.product.model.request.CreateProductRequest
import com.gym.management.domain.product.model.request.CreateProductTemplateRequest
import com.gym.management.domain.product.model.request.UpdateProductRequest
import com.gym.management.domain.product.model.request.UpdateProductTemplateRequest
import com.gym.management.domain.product.service.AProductService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Product")
class AProductController(
    private val aProductService: AProductService
) {
    @PostMapping("/admin/product-templates")
    fun createProductTemplates(
        @RequestBody createProductTemplateRequest: CreateProductTemplateRequest
    ): ApiResponse<ProductTemplateDTO> {
        return ApiResponse(
            data = aProductService.createProductTemplates(createProductTemplateRequest)
        )
    }

    @PutMapping("/admin/product-templates")
    fun updateProductTemplates(
        @RequestBody updateProductTemplateRequest: UpdateProductTemplateRequest
    ): ApiResponse<ProductTemplateDTO> {
        return ApiResponse(
            data = aProductService.updateProductTemplates(updateProductTemplateRequest)
        )
    }

    @GetMapping("/admin/product-templates")
    fun fetchProductTemplate(
        @RequestParam branchId: Int? = null,
        @RequestParam templateCode: String? = null,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @RequestParam sortBy: String,
        @RequestParam direction: String
    ): ApiResponse<PageResponse<ProductTemplateDTO>> {
        return ApiResponse(data = aProductService.fetchProductTemplate(branchId, templateCode, page, size, sortBy, direction))
    }

    @GetMapping("/admin/product-templates/{branchId}/{templateCode}/{productCode}")
    fun findBy(
        @PathVariable branchId: Int,
        @PathVariable templateCode: String,
        @PathVariable productCode: String
    ): ApiResponse<ProductTemplateDTO> {
        return ApiResponse(data = aProductService.findBy(branchId, templateCode, productCode))
    }

    @PostMapping("/admin/products")
    fun createProduct(
        @RequestBody createProductRequest: CreateProductRequest
    ): ApiResponse<ProductDTO> {
        return ApiResponse(
            data = aProductService.createProduct(createProductRequest)
        )
    }

    @PutMapping("/admin/products")
    fun updateProduct(
        @RequestBody updateProductRequest: UpdateProductRequest
    ): ApiResponse<ProductDTO> {
        return ApiResponse(
            data = aProductService.updateProduct(updateProductRequest)
        )
    }

    @GetMapping("/admin/products")
    fun fetchProduct(
        @RequestParam branchId: Int? = null,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @RequestParam sortBy: String,
        @RequestParam direction: String
    ): ApiResponse<PageResponse<ProductDTO>> {
        return ApiResponse(data = aProductService.fetchProduct(branchId, page, size, sortBy, direction))
    }

    @GetMapping("/admin/products/{branchId}/{productCode}")
    fun findBy(
        @PathVariable branchId: Int,
        @PathVariable productCode: String
    ): ApiResponse<ProductDTO> {
        return ApiResponse(data = aProductService.findBy(branchId, productCode))
    }
}