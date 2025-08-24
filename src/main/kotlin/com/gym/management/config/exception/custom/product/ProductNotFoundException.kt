package com.gym.management.config.exception.custom.product

import com.gym.management.config.exception.custom.CustomException

class ProductNotFoundException(
    message: String = "상품이 존재하지 않습니다.",
    code: String = "E008",
) : CustomException(message, code)