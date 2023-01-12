package basic.syntax.ps

fun main() {
    val m = mutableMapOf(
        1 to "jys",
        3 to "yoonsung",
        2 to "unluckyjung",
    )
    m.toSortedMap(compareByDescending { it }).forEach { number, name ->
        println("$number and $name")
    }
}
