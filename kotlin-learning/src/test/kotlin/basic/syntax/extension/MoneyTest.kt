package basic.syntax.extension

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class MoneyTest : BehaviorSpec({
    given("list 에 Money 가 담겨있을때") {
        val moneys = listOf(Money(0), Money(2), Money(4))

        `when`("확장함수를 이용한 sum 을 시도하면") {
            val sum = moneys.sum()

            then("모든 Money 의 합이 계산된다.") {
                var expectedSum = 0
                moneys.forEach {
                    expectedSum += it.value
                }

                sum.value shouldBe expectedSum
            }
        }
    }
})
