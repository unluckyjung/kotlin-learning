package basic

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFailsWith

class ExceptionTest {
    @Test
    fun exceptionTest1() {
        assertThrows<IllegalArgumentException> {
            MemberName("  ")
        }.shouldHaveMessage("이름은 공백일 수 없습니다.")
    }

    @Test
    fun exceptionTest2() {
        assertFailsWith<IllegalArgumentException> {
            MemberName("  ")
        }.shouldHaveMessage("이름은 공백일 수 없습니다.")
    }

    @Test
    fun customExceptionTest1() {
        shouldThrow<IllegalArgumentException> {
            throw CustomException()
        }.shouldHaveMessage("커스텀 예외입니다.")
    }

    @Test
    fun customExceptionTest2() {
        shouldThrowExactly<CustomException> {
            throw CustomException()
        }.shouldHaveMessage("커스텀 예외입니다.")
    }
}

class MemberName(val name: String) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 공백일 수 없습니다.")
        }
    }
}

class CustomException(
    message: String = "커스텀 예외입니다."
) : IllegalArgumentException(message)