package com.gym.management.common.utils

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class UserUtilsTests : BehaviorSpec({
    given("UserUtils.hashSHA256(input: String) 테스트"){
        `when`("1111을 넣으면"){
            val result = UserUtils.hashSHA256("1111")
            then("항상 같은 결과를 반환해야 한다."){
                result shouldBe "0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c"
            }
        }
    }
})