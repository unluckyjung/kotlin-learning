package basic.reflection

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReflectionMember(
    val name: String
)

class ReflectionTest {

    @DisplayName("java reflection 을 이용하면, null 으로 값을 채울 수 있다.")
    @Test
    fun javaReflectionTest() {
        val clazzConstructor = ReflectionMember::class.java.getDeclaredConstructor(String::class.java)
        val member = clazzConstructor.newInstance("goodall")

        member.name shouldBe "goodall"

        val nameField = ReflectionMember::class.java.getDeclaredField("name")
        nameField.isAccessible = true
        nameField.set(member, null)

        member.name shouldBe null
    }
}
