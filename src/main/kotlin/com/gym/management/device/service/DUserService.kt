package com.gym.management.device.service

import com.gym.management.common.model.branch.dto.BranchDTO
import com.gym.management.common.model.user.dto.LoginFormDTO
import com.gym.management.common.model.user.dto.UserDTO
import com.gym.management.common.service.BranchService
import com.gym.management.common.service.UserService
import com.gym.management.device.model.user.DCreateUserRequest
import com.gym.management.device.model.user.DLoginFormRequest
import org.springframework.stereotype.Service

@Service
class DUserService(
    private val userService: UserService,
    private val branchService: BranchService
) {
    fun createUser(createUserRequest: DCreateUserRequest): Boolean {
        userService.createUser(UserDTO(createUserRequest))
        branchService.createBranch(BranchDTO(createUserRequest))
        return true
    }

    fun login(loginFormRequest: DLoginFormRequest): Boolean {
        return userService.login(LoginFormDTO(loginFormRequest))
    }
}