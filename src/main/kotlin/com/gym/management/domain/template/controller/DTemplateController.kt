package com.gym.management.domain.template.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.service.DTemplateService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "template")
class DTemplateController(
    private val dtemplateService: DTemplateService,
) {
    @PostMapping("/device/templates")
    fun createTemplates(
        @RequestBody templateDTO: TemplateDTO
    ): ApiResponse<TemplateDTO> {
        return ApiResponse(
            data = dtemplateService.createTemplates(templateDTO)
        )
    }
}