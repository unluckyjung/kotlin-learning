package basic.syntax.ps

import java.util.*

fun main() {
    stackBasic()
    listBasic()
}

private fun listBasic() {
    val list = LinkedList<Int>().apply {
        addAll(mutableListOf(10, 20, 30))
    }

    val iter = list.iterator()
    while (iter.hasNext()) {
        print("${iter.next()},")   // 10,20,30
    }
    println()
    println()

    val listIter = list.listIterator()

    // [v,10,20,30]
    println("prev index: ${listIter.previousIndex()}")   // -1
    println("next index: ${listIter.nextIndex()}")   // 0
    println("value: ${listIter.next()}")    // 10   [10,v,20,30]
    println()

    // [10,v,20,30]
    println("prev index: ${listIter.previousIndex()}")   // 0
    println("next index: ${listIter.nextIndex()}")   // 1
    println("value: ${listIter.next()}")    // 20   [10,20,v,30]
    println()

    // [10,20,v,30]
    println("prev index: ${listIter.previousIndex()}")   // 1
    println("next index: ${listIter.nextIndex()}")   // 2
    println("value: ${listIter.next()}")    // 30   [10,20,30,v]
    println()

    // [prev] [10,20,30,v]
    println("prev index: ${listIter.previousIndex()}")   // 2
    println("next index: ${listIter.nextIndex()}")   // 3
    println("value: ${listIter.previous()}")    // 30   [10,20,v,30]
    println()

    // [prev] [10,20,v,30]
    println("prev index: ${listIter.previousIndex()}")   // 1
    println("next index: ${listIter.nextIndex()}")   // 2
    println("value: ${listIter.previous()}")    // 20   [10,v,20,30]
    println()

    // [prev] [10,v,20,30]
    println("prev index: ${listIter.previousIndex()}")   // 0
    println("next index: ${listIter.nextIndex()}")   // 1
    println("value: ${listIter.previous()}")    // 10   [v,10,20,30]
    println()
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
