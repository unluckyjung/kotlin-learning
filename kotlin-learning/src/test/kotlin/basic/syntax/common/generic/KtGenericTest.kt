package basic.syntax.common.generic

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class KtGenericTest {
    @Test
    fun genericMapTest() {
        val map = KtGenericMap(
            listOf(
                KtGenericData(key = "1", "123"),
                KtGenericData(key = "2", 123),
            ),
        )

        map.findByKey("1").value shouldBe "123"
        map.findByKey("2").value shouldBe 123
    }

    @Test
    fun genericClassTest() {
        val testClass = GenericClass(a = 10, b = "unluckyjung")
        testClass.genericSum(1, 2) shouldBe 3
    }

    @Test
    fun genericClassTest2() {
        val testClass = GenericClass(a = "goodall", b = "unluckyjung")
        testClass.genericSum(1, 2) shouldBe 3
    }
}
