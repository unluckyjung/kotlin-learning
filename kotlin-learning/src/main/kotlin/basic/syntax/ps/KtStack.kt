package basic.syntax.ps

import java.util.*

fun main() {
    stackBasic()
}

private fun stackBasic() {
    val s = Stack<Int>()
    s.push(10) // [10]
    s.push(20) // [10, 20]

    println(s.peek())   // (20)

    println(s.firstElement()) // (10)
    println(s.first())  // (10)

    println(s.lastElement()) // (20)
    println(s.last())   //(20)

    println(s.pop())    // print 20, [10]
    println(s.size) // 1

    println(s.pop())    // print 10, []

    if (s.isEmpty()) {
        println("empty") // "empty"
    }
}
