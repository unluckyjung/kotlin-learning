package basic.syntax

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainExactly
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RunCatching {

    @DisplayName("예외처리를 try Catch 를 이용하여 하는 예시")
    @Test
    fun test0() {
        val list = listOf(1, 2, 101, 3)

        val numbers = list.mapNotNull { value ->
            try {
                Number(value)
            } catch (e: Exception) {
                if (e is IllegalArgumentException) null
                else throw e
            }
        }
        numbers shouldContainExactly listOf(Number(1), Number(2), Number(3))
    }

    @DisplayName("runCatching 을 사용해서 특정 예외의 경우를 구분할수 있고, 실패의 디폴트값을 Null 로 줄 수있다.")
    @Test
    fun test1() {
        val list = listOf(1, 2, 101, 3)

        val numbers = list.mapNotNull { value ->
            runCatching {
                Number(value)
            }.onFailure { e ->
                if (e is IllegalStateException) throw e
            }.getOrNull()
        }

        numbers shouldContainExactly listOf(Number(1), Number(2), Number(3))
    }

    @DisplayName("runCatching 을 사용해서 특정 예외의 경우를 구분할수 있고, 실패의 디폴트값을 Null 로 줄 수있다.")
    @Test
    fun test2() {
        val list = listOf(1, 2, 3, -1)


        shouldThrow<IllegalStateException> {
            list.mapNotNull { value ->
                runCatching {
                    Number(value)
                }.onFailure { e ->
                    if (e is IllegalStateException) throw e
                }.getOrNull()
            }
        }
    }

    @DisplayName("runCatching 을 사용해서 특정 예외의 경우를 구분할수 있고, 실패의 디폴트값을 명시적으로 넣을 수 있다.")
    @Test
    fun test3() {
        val list = listOf(1, 2, 101, 3)

        val numbers = list.map { value ->
            runCatching {
                Number(value)
            }.onFailure { e ->
                if (e is IllegalStateException) throw e
            }.getOrDefault(Number(0))
        }
        numbers shouldContainExactly listOf(Number(1), Number(2), Number(0), Number(3))
    }

    @DisplayName("runCatching 을 사용해서 특정 예외의 경우를 구분할수 있고, 실패의 경우 로직을 태울 수 있다.")
    @Test
    fun test4() {
        val list = listOf(1, 2, 101, 3)

        val numbers = list.mapNotNull { value ->
            runCatching {
                Number(value)
            }.onFailure { e ->
                if (e is IllegalStateException) throw e
            }.getOrElse {
                println("일단 에러발생했음.. 에러 찍음.. input: $value")
                null
            }
        }
        numbers shouldContainExactly listOf(Number(1), Number(2), Number(3))
    }
}

data class Number(
    val value: Int,
) {
    init {
        check(value >= 0)    // 중요한 에러
        require(value in 0..100)    // 덜 중요한 에러
    }
}
