package com.gym.management.common.service

import com.gym.management.common.repository.user.BranchRepository
import com.gym.management.common.repository.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val branchRepository: BranchRepository
) {
}