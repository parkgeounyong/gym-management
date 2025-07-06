package com.gym.management.domain.user.service

import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.user.repository.UserRepository
import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.branch.service.BranchService
import com.gym.management.config.exception.custom.user.DuplicateIdException
import com.gym.management.domain.user.model.dto.CreateUserRequest
import com.gym.management.domain.user.model.entity.User
import org.springframework.stereotype.Service

@Service
class DUserService(
    private val userRepository: UserRepository,
    private val branchService: BranchService,
) {
    fun createUser(createUserRequest: CreateUserRequest): Boolean {
        val userDTO = UserDTO(createUserRequest)
        checkRegisterPossible(userDTO)
        userRepository.save(User(userDTO))
        branchService.createBranch(BranchDTO(createUserRequest))
        return true
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}