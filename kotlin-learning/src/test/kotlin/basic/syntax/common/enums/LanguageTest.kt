package basic.syntax.common.enums

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LanguageTest {

    @Test
    fun findByValue() {
        Language.findByValue("c++") shouldBe Language.CPP

        shouldThrowExactly<IllegalArgumentException> {
            Language.findByValue("none")
        }
    }

    @Test
    fun findByValue2() {
        Language.findByValueUseCache("c++") shouldBe Language.CPP

        shouldThrowExactly<IllegalArgumentException> {
            Language.findByValueUseCache("none")
        }
    }
}
