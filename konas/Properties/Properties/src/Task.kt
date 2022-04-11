class PropertyExample {
    var counter = 0
    var propertyWithCounter: Int = 0
        set(value) {
            field = value
            counter++
        }
}

class Member(
    private val name: String
) {
    val otherName: String
        get() = "$name and goodall"

    var number = 0
        set(value) {
            field = value * 10
        }
}

fun main() {
    val member = Member("jys")
    println(member.otherName) // "jys and goodall"
    member.number = 20
    print(member.number)    //  200
}
