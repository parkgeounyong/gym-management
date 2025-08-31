package com.gym.management.domain.template.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.template.model.dto.TemplateDTO
import com.gym.management.domain.template.model.request.ATemplateCreateRequest
import com.gym.management.domain.template.model.request.ATemplateUpdateRequest
import com.gym.management.domain.template.service.ATemplateService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@Tag(name = "template")
class ATemplateController(
    private val aTemplateService: ATemplateService,
) {
    @PostMapping("/admin/templates")
    fun createTemplates(
        @RequestBody aTemplateCreateRequest: ATemplateCreateRequest
    ): ApiResponse<TemplateDTO> {
        return ApiResponse(
            data = aTemplateService.createTemplates(aTemplateCreateRequest)
        )
    }

    @PutMapping("/admin/templates")
    fun updateTemplates(
        @RequestBody aTemplateUpdateRequest: ATemplateUpdateRequest
    ): ApiResponse<TemplateDTO> {
        return ApiResponse(
            data = aTemplateService.updateTemplates(aTemplateUpdateRequest)
        )
    }

    @GetMapping("/admin/templates")
    fun findBy(
        @RequestParam branchId: Int,
        @RequestParam startAt: LocalDateTime = LocalDateTime.now(),
        @RequestParam endAt: LocalDateTime = LocalDateTime.now().plusWeeks(1),
    ): ApiResponse<List<TemplateDTO>> {
        return ApiResponse(
            data = aTemplateService.findBy(branchId, startAt, endAt)
        )
    }

    @GetMapping("/admin/templates/{branchId}/{templateCode}")
    fun findBy(
        @PathVariable branchId: Int,
        @PathVariable templateCode: String,
    ): ApiResponse<TemplateDTO> {
        return ApiResponse(
            data = aTemplateService.findBy(branchId, templateCode)
        )
    }
}