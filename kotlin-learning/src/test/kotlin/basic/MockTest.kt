package basic

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
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
}

class Member(
    private val name: String
) {
    fun greet(): String {
        return "hello my name is $name"
    }

    companion object {
        fun hello(): String {
            return "hello member"
        }
    }
}