package com.gym.management.service

import com.gym.management.repository.user.BranchRepository
import com.gym.management.repository.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val branchRepository: BranchRepository
) {
}