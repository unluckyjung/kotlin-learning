package basic.junit

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

class JunitBeforeAllTest {

    @Test
    fun test1() {
        count shouldBe 1
    }

    @Test
    fun test2() {
        count shouldBe 1
    }

    companion object {
        var count = 0;

        @BeforeAll
        @JvmStatic
        internal fun setUp() {
            count++
        }
    }
}

// 기본값은
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 생명 주기 조절, 디폴트값은 PER_METHOD
class JunitBeforeAllTest2 {
    var count = 0;

    @BeforeAll
    internal fun setUp() {
        count++
    }


    @Test
    fun test1() {
        count shouldBe 1
    }

    @Test
    fun test2() {
        count shouldBe 1
    }
}
