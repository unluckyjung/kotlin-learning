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

    @DisplayName("getOrPut 을 호출했을때, key 값이 없으면 Put 되고 put 한 리턴값이 생성된다.")
    @Test
    fun getOrPutTest1() {
        val m = mutableMapOf<String, Int>()
        val result = m.getOrPut("yoonsung") { 30 }

        result shouldBe 30
        m["yoonsung"] shouldBe 30
    }

    @DisplayName("getOrPut 을 호출했을때, key 값이 있으면 Put 되지 않는다.")
    @Test
    fun getOrPutTest2() {
        val m = mutableMapOf<String, Int>().apply {
            this["yoonsung"] = 30
        }


        val result = m.getOrPut("yoonsung") { 20 }

        result shouldBe 30
        m["yoonsung"] shouldBe 30
    }

    @DisplayName("[collection] getOrPut 을 호출했을때, key 값이 없으면 Put 되고 put 한 리턴값이 생성된다.")
    @Test
    fun getOrPutTest3() {
        val m = mutableMapOf<String, MutableSet<Int>>()
        val result = m.getOrPut("yoonsung") { mutableSetOf(30) }

        result shouldBe mutableSetOf(30)
        m["yoonsung"] shouldBe mutableSetOf(30)
    }

    @DisplayName("value 가 collection 형태일때 관리하는방법 예시.")
    @Test
    fun getOrPutCollectionTest1() {
        val m = mutableMapOf<String, MutableSet<Int>>()

        m["goodall"]?.add(10) ?: run {
            m["goodall"] = mutableSetOf(10)
        }

        m["goodall"]?.add(20) ?: run {
            m["goodall"] = mutableSetOf(20)
        }

        m["goodall"] = mutableSetOf(10, 20)
    }

    @DisplayName("getOrDefault 를 이용하면, 조회시 값이 없을때 null 이 아닌 디폴트값을 가지게 할 수 있다.")
    @Test
    fun getOrDefaultTest1(){
        val m = mutableMapOf<Int, Int>()
        m[1] = m.getOrDefault(1, 0) + 10
        m[1] shouldBe 10

        m[1] = m.getOrDefault(1, 0) + 20
        m[1] shouldBe 30
    }
}

data class MapDummyData(
    val id1: Long,
    val id2: Long,
    val name: String = "jys",
)
