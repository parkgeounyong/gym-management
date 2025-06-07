package com.gym.management.admin.service

import com.gym.management.admin.model.user.ACreateUserRequest
import com.gym.management.common.model.branch.dto.BranchDTO
import com.gym.management.common.model.user.dto.UserDTO
import com.gym.management.common.service.BranchService
import com.gym.management.common.service.UserService
import org.springframework.stereotype.Service

@Service
class AUserService(
    private val userService: UserService,
    private val branchService: BranchService
) {
    fun createUser(aCreateUserRequest: ACreateUserRequest): Boolean {
        userService.createUser(UserDTO(aCreateUserRequest))
        branchService.createBranch(BranchDTO(aCreateUserRequest))
        return true
    }
}