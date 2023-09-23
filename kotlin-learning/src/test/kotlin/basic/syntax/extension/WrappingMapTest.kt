package basic.syntax.extension

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class WrappingMapTest : BehaviorSpec({
    given("get, set operator 를 구현해주면") {
        val wrappingMap = WrappingMap(mutableMapOf())
        val key = "goodall"
        val value = "yoosung"
        val expectedValue = "${WrappingMap.PREFIX} $value"

        `when`("[] 를사용했을때 ") {
            then("값 세팅, 조회가 가능하다.") {
                wrappingMap[key] = value
                wrappingMap[key] shouldBe expectedValue
            }
        }
    }
})
