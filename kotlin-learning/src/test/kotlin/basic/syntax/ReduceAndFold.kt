package basic.syntax

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReduceAndFold {

    @DisplayName("fold 의 경우, 타입변화하면서 처리가 가능하다.")
    @Test
    fun foldCollectionTest() {
        val numbers = mutableListOf(1, 2, 3, 4, 5)

        val (even, odd) = numbers.fold(
            Pair(mutableListOf<Int>(), mutableListOf<Int>())
        ) { listPair, number ->
            listPair.apply {
                when (number % 2) {
                    0 -> this.first.add(number)
                    else -> this.second.add(number)
                }
            }
        }

        even shouldBe mutableListOf(2, 4)
        odd shouldBe mutableListOf(1, 3, 5)
    }

    @DisplayName("fold 의 경우 초기값을 설정해주면서 로직을 태울 수 있다.")
    @Test
    fun foldSumTest() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val sum = numbers.fold(initial = 10) { sum, num ->
            sum + num
        }
        sum shouldBe 10 + 15
    }

    @DisplayName("fold 를 이용해서 type Casting 이 가능하다.")
    @Test
    fun foldTypeCastTest() {
        val numbers = mutableListOf(1, 2, 3, 4, 5)
        val str = numbers.fold("77") {
//                                     current, next ->
//            current + next.toString()
                current, next ->
            current + next
        }
        str shouldBe "7712345"
    }

    @DisplayName("rightFold 를 이용해서 우측에서부터 접근할 수 있다.")
    @Test
    fun rightFoldTest() {
        val numbers = mutableListOf(1, 2, 3, 4, 5)

        val str = numbers.foldRight("77") { next, current ->
            current + next.toString()
        }
        str shouldBe "7754321"
    }

    @DisplayName("reduce 를 사용하는 경우 합산 처리가 가능하다.")
    @Test
    fun reduceTest() {
        val numbers = listOf(1, 2, 3)
        val sum = numbers.reduce { acc, next -> acc + next }
        sum shouldBe 6
    }


    @DisplayName("reduce 사용시 empty Collection 의 경우 Exception 이 발생한다.")
    @Test
    fun reduceEmptyTest() {
        val numbers = emptyList<Int>()
        shouldThrowExactly<UnsupportedOperationException> {
            numbers.reduce { acc, next -> acc + next }
        }
    }


    @DisplayName("fold 사용시 empty Collection 의 경우 초기값이 반환된다.")
    @Test
    fun foldEmptyTest() {
        val numbers = emptyList<Int>()
        numbers.fold(0) { acc, next -> acc + next } shouldBe 0
    }


    @DisplayName("reduce 사용시, 연산작업이 있는경우 2번째 인자부터 적용된다.")
    @Test
    fun reduceBadTest2() {
        val numbers = (1..3).toList()

        // total의 초기값은 numbers[1]로 시작한다.
        val sumUsingReduce = numbers.reduce { total, num ->
            total + num * 2
        }

        // 1 <- 처리가 안됨 + 2x2 + 3x2
        sumUsingReduce shouldBe 11
    }

    @DisplayName("fold 사용시, 연산작업이 있는경우 1번째 인자부터 적용된다.")
    @Test
    fun foldSumTest1() {
        val numbers = (1..3).toList()

        // total의 초기값은 0으로 시작한다.
        val sumUsingFold = numbers.fold(0) { total, num ->
            total + num * 2
        }

        // 1x2 + 2x2 + 3x2
        sumUsingFold shouldBe 12
    }
}
