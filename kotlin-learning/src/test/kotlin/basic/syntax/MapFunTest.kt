package basic.syntax

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MapFunTest {

    @DisplayName("flatten 을 이용하면, list 안의 객체내 변수들을 평탄화 시킬 수 있다.")
    @Test
    fun flattenTest() {
        val list = listOf(
            MapDummyData(id1 = 1, id2 = 2),
            MapDummyData(id1 = 3, id2 = 4),
            MapDummyData(id1 = 5, id2 = 5),
        )


        val ids = list.map {
            setOf(it.id2, it.id1)
        }.flatten().toSet()

        ids.size shouldBe 5
        ids shouldContainAll listOf(1, 2, 3, 4, 5)
    }

    @DisplayName("flatMap 을 이용해 list 안의 list(숫자) 데이터들을 평탄화 시킬 수 있다.")
    @Test
    fun flatMapTest1() {
        val list = listOf(
            MapDummyData(id1 = 1, id2 = 2),
            MapDummyData(id1 = 3, id2 = 4),
            MapDummyData(id1 = 5, id2 = 5),
        )


        val ids = list.flatMap {
            setOf(it.id1, it.id2)
        }.toSet()

        ids.size shouldBe 5
        ids shouldContainAll listOf(1, 2, 3, 4, 5)
    }

    @DisplayName("flatMap 을 이용해 list 안의 list(문자열) 데이터들을 평탄화 시킬 수 있다.")
    @Test
    fun flatMapTest2() {
        val list = listOf(
            "abc",
            "bcde"
        )


        val ids = list.flatMap {
            it.toList()
        }.toSet()

        ids.size shouldBe 5
        ids shouldContainAll listOf('a', 'b', 'c', 'd', 'e')
    }
}

data class MapDummyData(
    val id1: Long,
    val id2: Long,
    val name: String = "jys",
)
