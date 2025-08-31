package com.gym.management.domain.user.service

import com.gym.management.domain.user.repository.UserRepository
import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.branch.service.BranchService
import com.gym.management.config.exception.custom.user.DuplicateIdException
import com.gym.management.config.exception.custom.user.UserNotFoundException
import com.gym.management.domain.branch.model.BranchDTOMapper.toBranchDTO
import com.gym.management.domain.user.model.UserDTOMapper.toUserDTO
import com.gym.management.domain.user.model.UserMapper.toUser
import com.gym.management.domain.user.model.UserMapper.update
import com.gym.management.domain.user.model.request.DCreateUserRequest
import com.gym.management.domain.user.model.request.DUpdateUserRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DUserService(
    private val userRepository: UserRepository,
    private val branchService: BranchService,
) {
    fun createUser(dCreateUserRequest: DCreateUserRequest): Boolean {
        val userDTO = dCreateUserRequest.toUserDTO()
        checkRegisterPossible(userDTO)
        userRepository.save(userDTO.toUser())
        branchService.createBranch(dCreateUserRequest.toBranchDTO())
        return true
    }

    @Transactional
    fun updateUser(dUpdateUserRequest: DUpdateUserRequest): Boolean {
        val userDTO = dUpdateUserRequest.toUserDTO()
        userRepository.findById(dUpdateUserRequest.userId)
            .orElseThrow { UserNotFoundException() }
            .update(userDTO)
        branchService.updateBranch(dUpdateUserRequest.toBranchDTO())
        return true
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}