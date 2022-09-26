package basic.junit

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource


class JunitParamsTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun sumTest(num: Int) {
        sum(num, 3) shouldBe num + 3
    }

    @ParameterizedTest
    @CsvSource("1,2", "3,4", "5,6")
    fun sumTest2(num1: Int, num2: Int) {
        sum(num1, num2) shouldBe num1 + num2
    }

    @ParameterizedTest
    @MethodSource("memberCompareTest")  // "memberCompareTest" 생략가능
    fun memberCompareTest(member1: Member, member2: Member) {
        member1 shouldBe member2
    }

    companion object {
        @JvmStatic
        fun memberCompareTest() = listOf(
            Arguments.of(Member("goodall"), Member("goodall")),
            Arguments.of(Member("unluckyjung"), Member("unluckyjung")),
        )
    }

    private fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }


    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class LifeCycleTest {

        @ParameterizedTest
        @MethodSource
        fun memberCompareTest(member1: Member, member2: Member) {
            member1 shouldBe member2
        }

        fun memberCompareTest() = listOf(
            Arguments.of(Member("goodall"), Member("goodall")),
            Arguments.of(Member("unluckyjung"), Member("unluckyjung")),
        )
    }

    data class Member(val name: String)
}