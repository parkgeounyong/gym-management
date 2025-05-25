package com.gym.management.admin.controller

import com.gym.management.admin.model.user.ACreateUserRequest
import com.gym.management.admin.service.AUserService
import com.gym.management.common.model.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "User")
class AUserController(
    private val aUserService: AUserService,
) {
    @PostMapping("/admin/user/users")
    fun createUser(
        @RequestBody aCreateUserRequest: ACreateUserRequest
    ): ApiResponse<Boolean> {
        return ApiResponse(data =  aUserService.createUser(aCreateUserRequest))
    }
}