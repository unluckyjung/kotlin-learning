package basic.mockk

import io.kotest.matchers.shouldBe
import io.mockk.*
import org.junit.jupiter.api.Test
import java.time.Year
import java.time.ZoneId
import java.time.ZonedDateTime

class MockTest {

    @Test
    fun mockkTestJunit() {

        val member = mockk<Member>()

        every {
            member.greet()
        } returns "hello test"

        member.greet() shouldBe "hello test"
    }

    @Test
    fun spykJunit() {
        val member = spyk(Member("jys"))
        every {
            member.greet()
        } returns "hello spyk"

        member.greet() shouldBe "hello spyk"
        member.hate() shouldBe "get out"
    }

    @Test
    fun companionObjectMockkTestJunit() {

        mockkObject(Member)
        every {
            Member.hello()
        }.returns("Hello Kotlin")

        Member.hello() shouldBe "Hello Kotlin"
    }

    @Test
    fun staticMockkTestJunit() {

        val mockedNow = Year.of(2222).atMonth(2).atDay(2).atTime(22, 22).atZone(ZoneId.of("Asia/Seoul"))
        mockkStatic(ZonedDateTime::class)

        every {
            ZonedDateTime.now()
        }.returns(
            mockedNow
        )

        ZonedDateTime.now() shouldBe mockedNow
    }

    @Test
    fun relaxedTest() {
        val member = mockk<Member>(relaxed = true)

        member.hate() shouldBe ""
    }

    @Test
    fun verifyTest() {
        val member = mockk<Member>()

//        every {
//            member.printHello(any())
//        } just runs

        // every 와 동일
        justRun {
            member.printHello(any())
        }

        val helloCount = 2
        for (i in 1..helloCount) {
            member.printHello(i.toString())
        }

        verify(exactly = 1) {
            member.printHello("1")
        }

        verify(exactly = 1) {
            member.printHello("2")
        }

        verify(exactly = 2) {
            member.printHello(any())
        }
    }

    @Test
    fun mockkDITest() {
        val dummy = mockk<Dummy>(relaxed = true)
        val team1 = Team("myteam", dummy = dummy)

        // 바로 mockk(relaxed = true) 로 의존 객체를 넣어줄 수 있다.
        val team2 = Team("myteam", dummy = mockk(relaxed = true))
    }
}

class Member(
    private val name: String
) {
    fun greet(): String {
        return "hello my name is $name"
    }

    fun hate(): String {
        return "get out"
    }

    fun printHello(name: String) {
        println("hello $name")
    }

    companion object {
        fun hello(): String {
            return "hello member"
        }
    }
}

data class Dummy(
    val property1: String
)


class Team(
    val name: String,
    val dummy: Dummy,
    members: List<Member> = listOf()
) {
    var members = members
        private set

    fun addMember(member: Member) {
        members = members.plus(member)
    }
}
