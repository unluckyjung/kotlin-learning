package basic.junit

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JunitStyleTest {
    @Test
    internal fun helloTest() {
        val languageName = "Kotest"
        val greetMsg = helloFun(languageName)
        greetMsg shouldBe "Hello $languageName"
    }

    private fun helloFun(languageName: String): String = "Hello $languageName"
}

