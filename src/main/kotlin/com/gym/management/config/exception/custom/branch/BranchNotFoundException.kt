package com.gym.management.config.exception.custom.branch

import com.gym.management.config.exception.custom.CustomException

class BranchNotFoundException(
    message: String = "지점이 존재하지 않습니다.",
    code: String = "E003",
) : CustomException(message, code)