package com.gym.management.device.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.device.model.user.DCreateUserRequest
import com.gym.management.device.model.user.DLoginFormRequest
import com.gym.management.device.service.DUserService
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
        @RequestBody createUserRequest: DCreateUserRequest
    ): ApiResponse<Boolean> {
        return ApiResponse(data = userService.createUser(createUserRequest))
    }

    @PostMapping("/device/user/login")
    fun login(
        @RequestBody loginRequest: DLoginFormRequest
    ): ApiResponse<String> {
        return ApiResponse(data = userService.login(loginRequest))
    }
}