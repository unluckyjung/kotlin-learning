package basic.junit

import basic.syntax.common.enums.WHETHER
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*


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

    @ParameterizedTest
    @EnumSource(value = WHETHER::class, names = ["SPRING"])
    fun enumTest1(whether: WHETHER) {
        whether shouldBe WHETHER.SPRING
    }

    @ParameterizedTest
    @EnumSource(value = WHETHER::class, names = ["SUMMER"], mode = EnumSource.Mode.EXCLUDE)
    fun enumTest2(whether: WHETHER) {
        whether.isHot(whether) shouldBe false
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