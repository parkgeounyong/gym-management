package com.gym.management.config.exception.custom.user

import com.gym.management.config.exception.custom.DomainException

class DuplicateIdException(
    message: String = "아이디가 중복되었습니다.",
    code: String = "E001",
) : DomainException(message, code)