package desginpattern

sealed class Programmer(
    private val name: String
) {

    fun programming() {
        // 프로그래밍을 위한 알고리즘 로직 순서는 이곳에 명시
        turnOnComputer()
        turnOnIde()
        typing()
    }

    private fun turnOnComputer() {
        println("$name 이 컴퓨터를 킵니다.")
    }

    // 프로그래머마다 다른 구체적인 구현은 자식클래스에 위임
    protected abstract fun turnOnIde()

    private fun typing() {
        println("코드를 타이핑 합니다.")
    }
}

class KotlinProgrammer(
    name: String
) : Programmer(name) {
    override fun turnOnIde() {
        println("인텔리제이를 킵니다.")
    }
}

class CsharpProgrammer(
    name: String
) : Programmer(name) {
    override fun turnOnIde() {
        println("비주얼 스튜디오를 킵니다.")
    }
}

fun main() {
    val kotlinProgrammer: Programmer = KotlinProgrammer("goodall")
    val csharpProgrammer: Programmer = CsharpProgrammer("yoonsung")

    kotlinProgrammer.programming()
    println()
    csharpProgrammer.programming()
}
