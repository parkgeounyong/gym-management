package com.gym.management.domain.user.service

import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.user.repository.UserRepository
import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.branch.service.BranchService
import com.gym.management.config.exception.custom.user.DuplicateIdException
import com.gym.management.config.exception.custom.user.UserNotFoundException
import com.gym.management.domain.user.model.dto.DCreateUserRequest
import com.gym.management.domain.user.model.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DUserService(
    private val userRepository: UserRepository,
    private val branchService: BranchService,
) {
    fun createUser(dCreateUserRequest: DCreateUserRequest): Boolean {
        val userDTO = UserDTO(dCreateUserRequest)
        checkRegisterPossible(userDTO)
        userRepository.save(User(userDTO))
        branchService.createBranch(BranchDTO(dCreateUserRequest))
        return true
    }

    @Transactional
    fun updateUser(dCreateUserRequest: DCreateUserRequest): Boolean {
        val userDTO = UserDTO(dCreateUserRequest)
        userRepository.findById(dCreateUserRequest.userId)
            .orElseThrow { UserNotFoundException() }
            .updateBy(userDTO)
        branchService.updateBranch(BranchDTO(dCreateUserRequest))
        return true
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}