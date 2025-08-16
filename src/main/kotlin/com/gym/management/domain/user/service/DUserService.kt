package com.gym.management.domain.user.service

import com.gym.management.config.exception.custom.DomainException
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.user.repository.UserRepository
import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.branch.service.BranchService
import com.gym.management.config.exception.custom.user.DuplicateIdException
import com.gym.management.domain.user.model.dto.UserRequest
import com.gym.management.domain.user.model.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DUserService(
    private val userRepository: UserRepository,
    private val branchService: BranchService,
) {
    fun createUser(userRequest: UserRequest): Boolean {
        val userDTO = UserDTO(userRequest)
        checkRegisterPossible(userDTO)
        userRepository.save(User(userDTO))
        branchService.createBranch(BranchDTO(userRequest))
        return true
    }

    @Transactional
    fun updateUser(userRequest: UserRequest): Boolean {
        val userDTO = UserDTO(userRequest)
        userRepository.findById(userRequest.userId)
            .orElseThrow { DomainException("User not found while updating user") }
            .updateBy(userDTO)
        branchService.updateBranch(BranchDTO(userRequest))
        return true
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}