package com.gym.management.config.exception.custom.user

import com.gym.management.config.exception.custom.CustomException

class UserNotFoundException(
    message: String = "사용자가 존재하지 않습니다.",
    code: String = "E004",
) : CustomException(message, code)