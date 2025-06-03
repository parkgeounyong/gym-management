package com.gym.management.admin.controller

import com.gym.management.admin.service.AUserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "User")
class AUserController(
    private val aUserService: AUserService,
) {
}