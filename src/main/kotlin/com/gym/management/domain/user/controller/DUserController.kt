package com.gym.management.domain.user.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.user.model.dto.CreateUserRequest
import com.gym.management.domain.user.service.DUserService
import com.gym.management.domain.user.model.dto.LoginFormDTO
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "User")
class DUserController(
    private val userService: DUserService
) {
    @PostMapping("/device/user/users")
    fun createUser(
        @RequestBody createUserRequest: CreateUserRequest
    ): ApiResponse<Boolean> {
        return ApiResponse(data = userService.createUser(createUserRequest))
    }

    @PostMapping("/device/user/login")
    fun login(
        @RequestBody loginFormDTO: LoginFormDTO
    ): ApiResponse<String> {
        return ApiResponse(data = userService.login(loginFormDTO))
    }
}