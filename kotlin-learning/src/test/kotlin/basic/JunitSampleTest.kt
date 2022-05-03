package basic

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class JunitSampleTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun sumTest(num: Int) {
        sum(num, 3) shouldBe num + 3
    }

    private fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}