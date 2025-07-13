package com.gym.management.domain.sale.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.sale.model.dto.SaleDTO
import com.gym.management.domain.sale.model.dto.SaleDetailDTO
import com.gym.management.domain.sale.service.DSaleService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "sale")
class DSaleController(
    private val dSaleService: DSaleService
) {
    @PostMapping("/device/sales")
    fun createSales(
        @RequestBody salesDTO: List<SaleDTO>
    ): ApiResponse<MutableList<Int>> {
        return ApiResponse(
            data = dSaleService.createSales(salesDTO)
        )
    }

    @PostMapping("/device/sales/details")
    fun createSaleDetails(
        @RequestBody saleDetailsDTO: List<SaleDetailDTO>
    ): ApiResponse<MutableList<Int>> {
        return ApiResponse(
            data = dSaleService.createSaleDetails(saleDetailsDTO)
        )
    }
}