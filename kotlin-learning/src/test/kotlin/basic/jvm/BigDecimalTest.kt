package basic.jvm

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class BigDecimalTest {

    @DisplayName("int 끼리 나누기 연산을 하면, 소수점이 반올림 처리되어버린다.")
    @Test
    fun divideTest1() {
        val num1 = BigDecimal(5)
        val num2 = BigDecimal(3)

        num1 / num2 shouldBe BigDecimal(2)
    }


    @DisplayName("long 끼리 나누기 연산을 하면, 소수점이 반올림 처리되어버린다.")
    @Test
    fun divideTest2() {
        val num1 = BigDecimal(5L)
        val num2 = BigDecimal(3L)

        num1 / num2 shouldBe BigDecimal(2)
    }

    @DisplayName("정수 형태의 String 끼리 나누기 연산을 하면, 소수점이 반올림 처리되어버린다.")
    @Test
    fun divideTest3() {
        val num1 = BigDecimal("5")
        val num2 = BigDecimal("3")

        num1 / num2 shouldBe BigDecimal(2)
    }

    @DisplayName("소수점(double) 형태의 나누기 연산을 하면, 소수점이 반올림 처리되어버린다.")
    @Test
    fun divideTest4() {
        val num1 = BigDecimal(5.00)
        val num2 = BigDecimal(3.00)

        num1 / num2 shouldBe BigDecimal(2)
    }


    @DisplayName("string + 소수점 형태의 나누기 연산을 하면, 소수점이 계산된다.")
    @Test
    fun divideTest5() {
        val num1 = BigDecimal("5.00")
        val num2 = BigDecimal("3.00")

        num1 / num2 shouldBe BigDecimal("1.67")
    }


    @DisplayName("string + 소수점 형태의 나누기 연산을 할때는, 앞의 숫자 소수점 자리수를 따라간다.")
    @Test
    fun divideTest6() {
        var num1 = BigDecimal("5.000")
        var num2 = BigDecimal("3.00")

        num1 / num2 shouldBe BigDecimal("1.667")    // num1 이 세자리수 까지 표현

        num1 = BigDecimal("5.000")
        num2 = BigDecimal("3.00000000")

        num1 / num2 shouldBe BigDecimal("1.667")    // num1 이 세자리수 까지 표현

        val num3 = BigDecimal(2)

        num3 / num1 / num2 shouldBe BigDecimal.ZERO // 가장 앞의 num3 이 소수점 표현하지 않음.

        BigDecimal("2.0") / num1 / num2 shouldBe BigDecimal("0.1")
    }

    @DisplayName("문자형태에 정수형 연산을 진행한경우 결과는 문자열 형태만 같다고 표시된다.")
    @Test
    fun divideTest7() {
        val num = BigDecimal(3)
        BigDecimal("2.00") / num shouldBe BigDecimal("0.67")

        BigDecimal("2.00") / num shouldNotBe  BigDecimal(0.67)   // BigDecimal(0.67) == 0.67000000000000003996802888650563545525074005126953125
    }

    @DisplayName("소수점이 있는 문자형태의 경우 동일한 문자형태만 같다고 표현한다.")
    @Test
    fun diffTest1() {
        val num1 = BigDecimal("5.000")
        val num2 = BigDecimal(5.000)

        num1 shouldNotBe num2

        num1 shouldBe BigDecimal("5.000")

        num2 shouldBe BigDecimal("5")
        num2 shouldBe BigDecimal(5L)
        num2 shouldBe BigDecimal(5.0)
        BigDecimal("5") shouldBe BigDecimal(5)
        BigDecimal("5") shouldBe BigDecimal(5.000)
    }

    @DisplayName("소수점이 없는 문자형태의 경우, 숫자 형태도 같다고 표현된다.")
    @Test
    fun diffTest2() {
        BigDecimal("5") shouldBe BigDecimal(5)
        BigDecimal("5") shouldBe BigDecimal(5L)
        BigDecimal("5") shouldBe BigDecimal(5.000)
    }
}
