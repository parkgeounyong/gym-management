package com.gym.management.config.exception.custom.template

import com.gym.management.config.exception.custom.CustomException

class TemplateNotFoundException(
    message: String = "템플릿이 존재하지 않습니다.",
    code: String = "E005",
) : CustomException(message, code)