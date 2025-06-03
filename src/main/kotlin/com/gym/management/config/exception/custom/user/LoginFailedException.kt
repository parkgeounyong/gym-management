package com.gym.management.config.exception.custom.user

import com.gym.management.config.exception.custom.DomainException

class LoginFailedException(
    message: String = "아이디 또는 비밀번호가 불일치합니다",
    code: String = "E002",
): DomainException(message, code)