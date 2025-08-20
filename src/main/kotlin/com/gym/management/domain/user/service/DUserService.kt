package com.gym.management.domain.user.service

import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.user.repository.UserRepository
import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.branch.service.BranchService
import com.gym.management.config.exception.custom.user.DuplicateIdException
import com.gym.management.config.exception.custom.user.UserNotFoundException
import com.gym.management.domain.user.model.dto.DUserRequest
import com.gym.management.domain.user.model.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DUserService(
    private val userRepository: UserRepository,
    private val branchService: BranchService,
) {
    fun createUser(dUserRequest: DUserRequest): Boolean {
        val userDTO = UserDTO(dUserRequest)
        checkRegisterPossible(userDTO)
        userRepository.save(User(userDTO))
        branchService.createBranch(BranchDTO(dUserRequest))
        return true
    }

    @Transactional
    fun updateUser(dUserRequest: DUserRequest): Boolean {
        val userDTO = UserDTO(dUserRequest)
        userRepository.findById(dUserRequest.userId)
            .orElseThrow { UserNotFoundException() }
            .updateBy(userDTO)
        branchService.updateBranch(BranchDTO(dUserRequest))
        return true
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}