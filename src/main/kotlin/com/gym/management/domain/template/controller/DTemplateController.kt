package com.gym.management.domain.template.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.template.model.entity.Template
import com.gym.management.domain.template.service.DTemplateService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "template")
class DTemplateController(
    private val dtemplateService: DTemplateService,
) {
    @GetMapping("/device/templates")
    fun createSales(): ApiResponse<MutableList<Template>> {
        return ApiResponse(
            data = dtemplateService.selectAll()
        )
    }
}