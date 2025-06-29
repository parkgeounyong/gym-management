package com.gym.management.domain.user.service

import com.gym.management.common.component.JwtComponent
import com.gym.management.domain.branch.model.dto.BranchDTO
import com.gym.management.domain.user.repository.UserRepository
import com.gym.management.domain.user.model.dto.LoginFormDTO
import com.gym.management.domain.user.model.dto.UserDTO
import com.gym.management.domain.branch.service.BranchService
import com.gym.management.common.utils.UserUtils
import com.gym.management.config.exception.custom.user.DuplicateIdException
import com.gym.management.config.exception.custom.user.LoginFailedException
import com.gym.management.domain.user.model.dto.CreateUserRequest
import com.gym.management.domain.user.model.entity.User
import org.springframework.stereotype.Service

@Service
class DUserService(
    private val userRepository: UserRepository,
    private val branchService: BranchService,
    private val jwtComponent: JwtComponent
) {
    fun createUser(createUserRequest: CreateUserRequest): Boolean {
        val userDTO = UserDTO(createUserRequest)
        checkRegisterPossible(userDTO)
        userRepository.save(User(userDTO))
        branchService.createBranch(BranchDTO(createUserRequest))
        return true
    }

    fun login(loginFormDTO: LoginFormDTO): String {
        val user = userRepository.findById(loginFormDTO.userId)
            .orElseThrow { LoginFailedException() }
        if (UserUtils.hashSHA256(loginFormDTO.password) != user.userPassword) throw LoginFailedException()
        return jwtComponent.generateToken(user.userId)
    }

    private fun checkRegisterPossible(userDTO: UserDTO) {
        if (userRepository.existsUserByUserId(userDTO.userId)) throw DuplicateIdException()
    }
}