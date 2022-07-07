package basic

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test

class ValidateTest {

    @Test
    fun requireTest() {
        RequireMember("jys")

        shouldThrowExactly<IllegalArgumentException> {
            RequireMember(" ")
        }.shouldHaveMessage("이름 입력이 잘못되었습니다.")
    }

    @Test
    fun checkTest() {
        CheckMember("jys")

        shouldThrowExactly<IllegalStateException> {
            CheckMember(" ")
        }.shouldHaveMessage("잘못된 상태값입니다.")
    }

    @Test
    fun assertTest() {
        AsserMember(10)

        shouldThrowExactly<AssertionError> {
            AsserMember(-1)
        }.shouldHaveMessage("나이는 0살 이상이여야 합니다.")
    }
}

class RequireMember(
    name: String
) {
    init {
        require(name.isBlank().not()) {
            "이름 입력이 잘못되었습니다."
        }
    }
}

class CheckMember(
    state: String
) {
    init {
        check(state.isBlank().not()) {
            "잘못된 상태값입니다."
        }
    }
}

class AsserMember(
    age: Int
) {
    init {
        assert(age >= 0) {
            "나이는 0살 이상이여야 합니다."
        }
    }
}
