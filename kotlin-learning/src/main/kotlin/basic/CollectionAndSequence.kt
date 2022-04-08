package basic

class LazyCollection {
}

fun main() {
    val people = listOf(Person("jys", 29), Person("goodall", 30))

    // kotlin collection
    people.map {
        println("call map")
        it.age
    }.filter {
        println("call filter $it")
        it >= 30
    }

    println("=====================")

    // kotlin asSequence
    people.asSequence().map {
        println("call map")
        it.age
    }.filter {
        println("call filter $it")
        it >= 30
    }
}

class Person constructor(
    val name: String,
    val age: Int
)