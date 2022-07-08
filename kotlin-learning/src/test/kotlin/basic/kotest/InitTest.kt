package basic.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class InitTest : FunSpec() {

    init {
        test("this is first test") {
            val name = "hello kotest!"
            val actual = name.length
            actual shouldBe 13
        }
    }
}