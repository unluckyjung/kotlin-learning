package basic.kotest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BDDSpecTest : BehaviorSpec({
    given("환영 메시지") {
        val languageName = "Kotest"
        `when`("언어가 들어오면") {
            then("언어에 환영메시지를 이어붙여 출력한다.") {
                helloFun(languageName) shouldBe "Hello $languageName"
            }
        }
    }
})

fun helloFun(languageName: String): String = "Hello $languageName"
