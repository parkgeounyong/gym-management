package com.gym.management.config.exception.custom.category

import com.gym.management.config.exception.custom.CustomException

class ProductCategoryNotFoundException(
    message: String = "상품 카테고리가 존재하지 않습니다.",
    code: String = "E007",
) : CustomException(message, code)