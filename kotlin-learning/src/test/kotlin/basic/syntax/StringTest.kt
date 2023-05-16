package basic.syntax

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringTest {

    @DisplayName("format 을 이용하면 쉽게 문자열 매칭을 할 수 있다.")
    @Test
    fun formatTest() {
        val str = "goodall %s %s"
        str.format(123, "unluckyjung") shouldBe "goodall 123 unluckyjung"
    }
}
