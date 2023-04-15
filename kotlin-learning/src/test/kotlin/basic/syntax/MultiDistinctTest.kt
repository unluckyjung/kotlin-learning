package basic.syntax

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MultiDistinctTest {

    @DisplayName("중복처리 조건이 2개인 경우, Pair 를 이용하면 필터링된다.")
    @Test
    fun twoConditionDistinctTest() {
        val sameMan = Man()
        val sameNameAndNickName = Man(githubName = "yoonsung")
        val diffMan = Man(name = "goodall")

        val list = listOf(sameMan, sameMan, sameNameAndNickName, diffMan)

        val distinctByNameAndNickName = list.distinctBy {
            Pair(it.name, it.nickName)
        }

        distinctByNameAndNickName.size shouldBe 2
        distinctByNameAndNickName.shouldContainAll(sameMan, diffMan)
    }


    @DisplayName("같은 이름과 닉네임을 가진것들은 1개로 처리된다. (distinct 는 Selector 사용에 주의)")
    @Test
    fun twoConditionDistinctTest2() {
        val man = Man() // sameNameAndNickName
        val diffName = Man(name = "a")
        val diffNickName = Man(nickName = "b")
        val diffGithubName = Man(githubName = "c") // sameNameAndNickName
        val diffAge = Man(age = 10) // sameNameAndNickName

        val list = listOf(man, diffName, diffNickName, man, diffGithubName, diffAge, man)

        // name 과 nickName 이 같은것은 하나로 처리
        val distinctByNameAndNickName = list.distinctBy {
            listOf(it.name, it.nickName)
        }

        distinctByNameAndNickName.size shouldBe 3
    }


    @DisplayName("중복 조건이 3개인 경우, distinctBy 에 list 를 이용하면된다.")
    @Test
    fun threeConditionDistinctTest() {
        val sameMan = Man()
        val diffMan = Man(age = 10)

        val list = listOf(sameMan, sameMan, sameMan, diffMan)

        val distinctByNames = list.distinctBy {
            listOf(it.name, it.githubName, it.nickName)
        }

        // name 에 관련된 조건 3개가 전부 같음.
        distinctByNames.size shouldBe 1
        distinctByNames.shouldContainAll(sameMan)


        // age 는 달라서 2개로 구분되어짐.
        val distinctByNames2 = list.distinctBy {
            listOf(it.name, it.githubName, it.nickName, it.age)
        }
        distinctByNames2.size shouldBe 2
        distinctByNames2.shouldContainAll(sameMan, diffMan)
    }

    @DisplayName("중복조건이 처리되는경우, list 상 앞에있는 객체가 우선으로 남는다.")
    @Test
    fun distinctOrderTest() {
        val sameNameMan1 = Man(age = 30)
        val sameNameMan2 = Man(age = 20)

        val list = listOf(sameNameMan1, sameNameMan2)

        val distinctByName = list.distinctBy {
            it.name
        }

        distinctByName.size shouldBe 1
        distinctByName.shouldContain(sameNameMan1)
    }
}

data class Man(
    val name: String = "yoonsung",
    val nickName: String = "goodall",
    val githubName: String = "unluckyjung",
    val age: Int = 31,
)
