package basic.kotest

import io.kotest.matchers.equality.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RecursiveCompareTest {

    @DisplayName("shouldBeEqualToComparingFieldsTest")
    @Test
    fun recursiveCompareTest1() {
        val privateMember1 = PrivateMember(age = 1, name = "jys", nickName = "goodall")
        val privateMember2 = PrivateMember(age = 1, name = "jys", nickName = "goodall")

        privateMember1 shouldBeEqualToComparingFields privateMember2  // pass

        // private 은 무시한다. getter 가 있는 nickName 만 같은지 테스트한다.
        val privateMember3 = PrivateMember(age = 2, name = "yoonsung", nickName = "goodall")
        privateMember1 shouldBeEqualToComparingFields privateMember3  // pass


        // shouldNot, private 도 같이 확인하게 할 수 있다.
        privateMember1.shouldNotBeEqualToComparingFields(privateMember3, ignorePrivateFields = false)

        // nickName 을 제외하고 비교할 수 있다.
        privateMember1.shouldBeEqualToComparingFieldsExcept(
            PrivateMember(age = 1, name = "jys", nickName = "fortune"),
            ignoreProperty = PrivateMember::nickName
        )
    }

    @DisplayName("shouldBeEqualToUsingFields Test")
    @Test
    fun recursiveCompareTest2() {
        val member1 = Member(age = 1, name = "jys", nickName = "goodall")
        val member2 = Member(age = 1, name = "jys", nickName = "goodall")
        val member3 = Member(age = 1, name = "yoonsung", nickName = "goodall")

        // 지정해주지 않으면 기본적으로 모든 필드를 비교한다.
        member1.shouldBeEqualToUsingFields(member2)
        member1.shouldNotBeEqualToUsingFields(member3)

        // age, nickName 필드가 같은지를 확인한다.
        member1.shouldBeEqualToUsingFields(member3, Member::age, Member::nickName)

        val member4 = Member(age = 1, name = "jys", nickName = "fortune")
        // nickName 이 달라서 !=
        member1.shouldNotBeEqualToUsingFields(member4, Member::nickName)
    }

    @DisplayName("shouldBeEqualToIgnoringFields")
    @Test
    fun recursiveCompareTest3() {

        val member1 = Member(age = 1, name = "jys", nickName = "goodall")
        val member2 = Member(age = 2, name = "jys", nickName = "fortune")

        // age 을 제외한 필드를 비교한다.
        member1.shouldNotBeEqualToIgnoringFields(member2, Member::age)

        // age, nickName 을 제외한 필드를 비교한다.
        member1.shouldBeEqualToIgnoringFields(member2, Member::age, Member::nickName)
    }

    @DisplayName("List shouldBeEqualToComparingFields 비교")
    @Test
    fun listRecursiveCompareTest4() {

        val member1 = Member(age = 1, name = "jys", nickName = "goodall")
        val member2 = Member(age = 2, name = "jys", nickName = "fortune")

        val team1 = Team(listOf(member1, member2))
        val team2 = Team(listOf(member1, member2))

        team1.shouldBeEqualToComparingFields(team2) // ==

        // member2 가 없음.
        team1.shouldNotBeEqualToComparingFields(Team(listOf(member1)))  // !=

        val member3 = Member(age = 3, name = "jys", nickName = "fortune")
        // 다른 age 를 가진 멤버가 들어감.
        team1.shouldNotBeEqualToComparingFields(Team(listOf(member1, member3))) // !=

        // 다른 객체이지만 값은 완전히 동등, 하지만 객체 해시값이 달라서 != (필드내부값들로 확인하는것이 아님)
        val member4 = Member(age = 2, name = "jys", nickName = "fortune")
        team1.shouldNotBeEqualToComparingFields(Team(listOf(member1, member4))) // !=
    }
}

class Team(
    val members: List<Member>
)

class PrivateMember(
    private val age: Int,
    private val name: String,
    val nickName: String,
)


class Member(
    val age: Int,
    val name: String,
    val nickName: String,
)