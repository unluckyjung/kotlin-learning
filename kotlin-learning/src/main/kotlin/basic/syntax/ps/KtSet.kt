package basic.syntax.ps

import java.util.*

data class SetMember(
    val age: Int,
    val grade: String,
)

fun main() {
    basicSet()
    objectSortedSet()
    multiset()
}

private fun multiset() {
    val multiset = TreeMap<Int, MutableList<Int>>()

    multiset[2] = mutableListOf(20)
    multiset[1] = mutableListOf(10)
    multiset[1]?.add(11)

    println(multiset)
}

private fun basicSet() {
    val s = mutableSetOf<Int>()
    s.add(5)
    s.add(3)
    s.add(10)
    s.add(7)

    println(s.first())  // 5
    println(s.last())   // 7


    val sortedSet = s.toSortedSet()
    println(sortedSet.first()) // 3
    println(sortedSet.last()) // 10

    val sortedSet2 = sortedSetOf<Int>()
    sortedSet2.add(10)
    sortedSet2.add(5)
    println(sortedSet2.first()) // 5

    if (s.contains(3)) {
        println("exist")
    }
    s.remove(1)
}

private fun objectSortedSet() {
    val s = sortedSetOf<SetMember>(
        compareBy({ it.age }, { it.grade })
    )
    s.add(SetMember(5, "A"))
    s.add(SetMember(10, "B"))
    s.add(SetMember(1, "C"))
    s.add(SetMember(1, "A"))

    println(s.first())  //  SetMember(age=1, grade=A)
}
