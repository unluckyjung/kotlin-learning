package basic.syntax

open class Member(
    val name: String
) {

    init {
        // YoonSung 의 sayHello를 호출 해버림
        sayHello()
    }

    open fun sayHello() {
        print("Hello")
    }

}

class YoonSung(
    name: String,
    val nickName: String
) : Member(name) {

    override fun sayHello() {
        print("Hello $nickName")
    }
}

fun main() {
    // Hello null,
    val jys = YoonSung("jys", "goodall")
}
