package basic.syntax.common.property

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BackingMember(
    name: String
) {
    var name: String = name
        get() {
            return field.ifBlank { "defaultName" }
        }
        set(name) {
            field = "new $name"
        }

    var overflowName: String = name
        get() {
            // field 를 사용하지 않음.
            // val 로 쓴다면 컴파일 타임에 에러가 나오긴함.
            return overflowName.ifBlank { "wrongName" }
        }
        private set

    val funName = funName()

    private fun funName(): String {
        CALL_COUNTER++
        return "fun ${this.name}"
    }

    companion object {
        var CALL_COUNTER = 0
    }
}

class BackingNumbers(
    var numbers: MutableList<Int>
) {
    val sum = calculate()
    val referenceSumTest = numbers.sum()

    private fun calculate(): Int {
        CALL_COUNTER++
        return numbers.sum() - 10
    }

    companion object {
        var CALL_COUNTER = 0
    }
}

class BackingPropertyTest {
    @BeforeEach
    internal fun setUp() {
        BackingNumbers.CALL_COUNTER = 0
        BackingMember.CALL_COUNTER = 0
    }

    @Test
    fun backingFieldTest() {
        val name = "yoonsung"
        val backingMember = BackingMember(name)
        backingMember.name shouldBe name
    }

    @Test
    fun backingFieldTest2() {
        val name = ""
        val backingMember = BackingMember(name)
        backingMember.name shouldBe "defaultName"
    }

    @Test
    fun backingFieldTest3() {
        val name = "yoonsung"
        val backingMember = BackingMember(name)
        backingMember.name = "goodall"

        backingMember.name shouldBe "new goodall"
    }


    @DisplayName("Backing Field 를 사용하지 않고, 프로퍼티 이름을 사용하면 무한참조가 일어나 스택오브펄로우가 발생한다.")
    @Test
    fun backingFieldTest4() {
        val name = "yoonsung"
        val backingMember = BackingMember(name)

        shouldThrowExactly<StackOverflowError> {
            backingMember.overflowName
        }
    }


    @DisplayName("프로퍼티 값 설정후, 조회를 여러번해도 연결된 함수는 1회만 동작한다.")
    @Test
    fun backingFieldTes5() {
        BackingMember.CALL_COUNTER shouldBe 0

        val name = "yoonsung"
        val backingMember = BackingMember(name)

        BackingMember.CALL_COUNTER shouldBe 1

        backingMember.funName shouldBe "fun $name"
        backingMember.funName shouldBe "fun $name"
        backingMember.funName shouldBe "fun $name"
        backingMember.funName shouldBe "fun $name"

        BackingMember.CALL_COUNTER shouldBe 1

        val newName = "goodall"
        backingMember.name = newName

        backingMember.funName shouldBe "fun $name"
        BackingMember.CALL_COUNTER shouldBe 1
    }


    @Test
    fun backingFieldTest6() {
        BackingNumbers.CALL_COUNTER shouldBe 0
        val numbers = BackingNumbers(mutableListOf(1, 2, 3, 10))
        numbers.sum shouldBe 6
        numbers.sum shouldBe 6
        numbers.sum shouldBe 6
        BackingNumbers.CALL_COUNTER shouldBe 1

        numbers.numbers = mutableListOf(1, 10)

        // numbers 가 바뀌었어도 프로퍼티값은 변하지 않음.
        numbers.sum shouldNotBe 1
        numbers.sum shouldBe 6

        BackingNumbers.CALL_COUNTER shouldBe 1
    }

    @Test
    fun backingFieldTest7() {
        BackingNumbers.CALL_COUNTER shouldBe 0
        val numbers = BackingNumbers(mutableListOf(1, 2, 3, 10))
        numbers.sum shouldBe 6
        numbers.sum shouldBe 6
        numbers.sum shouldBe 6
        BackingNumbers.CALL_COUNTER shouldBe 1

        numbers.numbers.add(100)

        // numbers 안의 데이터들이 바뀌었어도 프로퍼티값은 변하지 않음.
        numbers.sum shouldNotBe 106
        numbers.sum shouldBe 6

        BackingNumbers.CALL_COUNTER shouldBe 1
    }
}
