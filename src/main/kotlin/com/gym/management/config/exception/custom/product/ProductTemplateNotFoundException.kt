package com.gym.management.config.exception.custom.product

import com.gym.management.config.exception.custom.CustomException

class ProductTemplateNotFoundException(
    message: String = "상품 템플릿이 존재하지 않습니다.",
    code: String = "E006",
) : CustomException(message, code)