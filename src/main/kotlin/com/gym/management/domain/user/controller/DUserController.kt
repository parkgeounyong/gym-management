package com.gym.management.domain.user.controller

import com.gym.management.common.model.ApiResponse
import com.gym.management.domain.user.model.dto.UserRequest
import com.gym.management.domain.user.service.DUserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "User")
class DUserController(
    private val userService: DUserService
) {
    @PostMapping("/device/users")
    fun createUser(
        @RequestBody userRequest: UserRequest
    ): ApiResponse<Boolean> {
        return ApiResponse(data = userService.createUser(userRequest))
    }
}