package com.gym.management.domain.product.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.common.model.PageResponse
import com.gym.management.domain.product.model.dto.ProductDTO
import com.gym.management.domain.product.model.dto.ProductTemplateDTO
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

    @GetMapping("/admin/product-templates/{branchId}")
    fun findBy(
        @PathVariable branchId: Int,
        @RequestParam templateCode: String,
        @RequestParam productCode: String
    ): ApiResponse<ProductTemplateDTO> {
        return ApiResponse(data = aProductService.findBy(branchId, templateCode, productCode))
    }

    @PostMapping("/admin/products")
    fun createProduct(
        @RequestBody productDTO: ProductDTO
    ): ApiResponse<ProductDTO> {
        return ApiResponse(
            data = aProductService.createProduct(productDTO)
        )
    }

    @PutMapping("/admin/products")
    fun updateProduct(
        @RequestBody productDTO: ProductDTO
    ): ApiResponse<ProductDTO> {
        return ApiResponse(
            data = aProductService.updateProduct(productDTO)
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

    @GetMapping("/admin/products/{branchId}")
    fun findBy(
        @PathVariable branchId: Int,
        @RequestParam productCode: String
    ): ApiResponse<ProductDTO> {
        return ApiResponse(data = aProductService.findBy(branchId, productCode))
    }
}