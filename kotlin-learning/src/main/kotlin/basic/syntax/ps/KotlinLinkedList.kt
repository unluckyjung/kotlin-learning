package basic.syntax.ps

import java.util.*

fun main() {
    linkedListBasic()
    listIterator()
    listMutableIterator()
}

fun linkedListBasic() {
    val list: LinkedList<Int> = LinkedList()
    list.add(1) // [1]
    list.add(3) // [1, 3]
    list.add(index = 1, element = 2) // [1, 2, 3]

    list.remove(element = 1) // [2, 3]
    list.remove(element = 3) // [2]
    println(list.remove(-1)) // false

    list.add(0, 10) //  [10, 2]
    list.add(2, 3) //  [10, 2, 3]
    list.add(2, 4) //  [10, 2, 4, 3]

    println(list.first) // 10
    println(list.last) // 3
    println(list[2]) // 4

    // 원하는 값(2)의 인덱스를 찾은뒤 삭제하는경우

    // [10, 2, 4, 3]
    val targetIndex = list.indexOf(2) // 1;
    list.removeAt(targetIndex)
    println(list)   // [10, 4, 3]
}

private fun listIterator() {
    val list = LinkedList(listOf(10, 20, 30))

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

private fun listMutableIterator() {
    val list = LinkedList<Int>().apply {
        addAll(mutableListOf(10, 20, 30, 40, 50))
    }

    val iter = list.listIterator()  // [^,10,20,30,40,50]

    println(iter.next()) // 10, [10,^,20,30,40,50]
    iter.remove()   // remove 는 iterator 가 마지막으로 반환한 얘를 지운다. 즉, next, previous 호출전에 remove 호출시 에러발생
    println(list)   // [^,20,30,40,50]

    iter.next() // [20,^,30,40,50]
    iter.next() // [20,30,^,40,50]

    iter.add(35)  // [20,30,35,^,40,50]
    println(list)
    println(iter.previous()) // 35 [20,30,^,35,40,50]
    iter.remove() // [20,30,^,40,50]
    println(list)

    iter.previous() // [20,^,30,40,50]
    iter.previous() // [^,20,30,40,50]
    iter.remove()
    println(list) // [^,30,40,50]

    iter.next() // [30,^,40,50]
    iter.next() // [30,40,^,50]
    iter.remove()
    println(list) // [30,50]
}
