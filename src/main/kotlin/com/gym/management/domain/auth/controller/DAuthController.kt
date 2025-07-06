package com.gym.management.domain.auth.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.auth.model.dto.LoginFormDTO
import com.gym.management.domain.auth.service.DAuthService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Auth")
class DAuthController(
    private val dAuthService: DAuthService
) {
    @PostMapping("/device/auth/tokens")
    fun login(
        @RequestBody loginFormDTO: LoginFormDTO
    ): ApiResponse<String> {
        return ApiResponse(data = dAuthService.login(loginFormDTO))
    }
}