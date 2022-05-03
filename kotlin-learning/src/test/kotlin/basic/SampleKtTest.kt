package basic

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class SampleKtTest : BehaviorSpec({
    given("4개의 숫자가 주어지고") {
        `when`("3개의 숫자를 더하면") {
            then("마지막 숫자의 값이 나온다.") {
                forAll(
                    row(1, 2, 3, 6)
                ) { a, b, c, d ->
                    a + b + c shouldBe d
                }
            }
        }
    }

    given("2개의 숫자가 더해지고") {
        fun sum(num1: Int, num2: Int) = num1 + num2
        `when`("두개를 sum 함수를 거치면") {
            then("더했을때의 결과가 나온다.") {
                forAll(
                    row(1, 2),
                    row(3, 4),
                    row(5, 6)
                ) { num1, num2 ->
                    sum(num1, num2) shouldBe num1 + num2
                }
            }
        }
    }

    given("1개의 숫자가 더해지고") {
        val nums = listOf(1, 2, 3, 4)
        `when`("자기 자신을 더하면") {
            then("2배 곱한결과가 나온다.") {
                nums.forAll {
                    it + it shouldBe it * 2
                }
            }
        }
    }
})