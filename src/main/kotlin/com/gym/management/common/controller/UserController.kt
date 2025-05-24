package com.gym.management.common.controller

import com.gym.management.common.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "User")
class UserController(
    private val userService: UserService
) {
}