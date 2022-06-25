package basic

import io.kotest.matchers.collections.*
import org.junit.jupiter.api.Test

class CollectionTest {
    private val list = listOf(1, 2, 3, 4)

    @Test
    fun containTest() {
        list shouldContain 1
        list shouldNotContain 5
    }

    @Test
    fun containExactlyTest() {
        list shouldContainExactly list
        list shouldNotContainExactly listOf(1, 2, 3)
    }

    @Test
    fun containAllTest() {
        list shouldContainAll listOf(1, 2)
        list shouldContainAll listOf(1, 2, 3, 4)
    }

    @Test
    fun containUniqueTest() {
        list.shouldBeUnique()

        val list2 = listOf(1, 1)
        list2.shouldNotBeUnique()
    }

    @Test
    fun containNullTest() {
        val list2 = listOf(null, 1, 2)
        list2.shouldContainNull()
    }
}
