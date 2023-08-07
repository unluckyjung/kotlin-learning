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
}
