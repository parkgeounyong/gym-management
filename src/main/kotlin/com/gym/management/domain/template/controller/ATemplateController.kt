package com.gym.management.domain.template.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.service.ATemplateService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "template")
class ATemplateController(
    private val aTemplateService: ATemplateService,
) {
    @PostMapping("/admin/templates")
    fun createTemplates(
        @RequestBody templateDTO: TemplateDTO
    ): ApiResponse<TemplateDTO> {
        return ApiResponse(
            data = aTemplateService.createTemplates(templateDTO)
        )
    }
}