package com.gym.management.domain.user

import com.gym.management.config.exception.custom.user.DuplicateIdException
import com.gym.management.domain.branch.service.BranchService
import com.gym.management.domain.user.model.request.DCreateUserRequest
import com.gym.management.domain.user.repository.UserRepository
import com.gym.management.domain.user.service.DUserService
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.*

class DUserServiceTests : BehaviorSpec({
    val userRepository = mockk<UserRepository>()
    val branchService = mockk<BranchService>()
    val dUserService = DUserService(userRepository, branchService)
    val dCreateUserRequset = DCreateUserRequest(
        userId = "userId",
        userPassword = "PW1234",
        userRole = "USER",
        userName = "userName",
        userPhone = "010-1234-5678",
        userEmail = "test@example.com",
        branchName = "branchName",
        branchAddress = "branchAddress",
    )

    given("DuserService.checkRegisterPossible() 분기 간접 테스트") {
        `when`("사용자 등록 시 해당 id가 이미 존재하면") {
            every { userRepository.existsUserByUserId("userId") } returns true
            then("DuplicateIdException을 던진다") {
                shouldThrow<DuplicateIdException> {
                    dUserService.createUser(dCreateUserRequset)
                }
            }
        }
        `when`("사용자 등록 시 해당 id가 이미 존재하지 않으면") {
            every { userRepository.existsUserByUserId("userId") } returns false
            every { userRepository.save(any()) } answers { firstArg() }
            every { branchService.createBranch(any()) } answers { firstArg() }
            then("DuplicateIdException을 던지지않는다.") {
                shouldNotThrow<DuplicateIdException> {
                    dUserService.createUser(dCreateUserRequset)
                }
            }
        }
    }
})