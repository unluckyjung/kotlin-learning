package basic.kotest

import io.kotest.core.annotation.Ignored
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TestDisableTest : BehaviorSpec({
    given("테스트") {
        xWhen("실행 안됌") {
            then("안됌") {
                true shouldBe false
            }
        }
        `when`("실행") {
            then("됌") {
                true shouldBe true
            }
            xthen("안됌") {
                true shouldBe false
            }
        }
    }
})

@Ignored
class TestDisable2 : BehaviorSpec({
    given("테스트") {
        `when`("실행") {
            then("안됌") {
                true shouldBe false
            }
        }
    }
})