package basic.syntax.ps

import java.util.*


fun main() {
    queue()
    deque()
}

private fun deque() {
    val dq: Deque<Int> = LinkedList()
    dq.add(20) // [20]
    dq.addFirst(10) // [10,20]
    dq.addLast(30) // [10,20,30]

    println(dq.first)   // 10
    println(dq.last)    // 30

    dq.removeFirst() // [20,30]
    println(dq.first)   // 20
}

private fun queue() {
    val q: Queue<Int> = LinkedList()
    q.add(10)
    q.add(20)
    println(q.element())    // 10
    q.remove()
    println(q.element())    // 20

    q.clear()

    if (q.isEmpty()) {
        println("empty")
    }
}

