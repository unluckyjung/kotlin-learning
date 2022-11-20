package basic.syntax.ps

import java.util.*

class KtPriorityQueue {

}

data class Man(
    val age: Int,
    val grade: Int,
    val name: String,
) : Comparable<Man> {

    // 기본 정렬 조건 정의: 나이가 많고, 등급은 낮을수록 우선순위
    override fun compareTo(other: Man): Int {
        return compareValuesBy(
            this, other,
            { -it.age }, { it.grade }
        )
    }

//    override fun compareTo(other: Man): Int {
//        return if (-age.compareTo(other.age) == 0) {
//            grade.compareTo(other.grade)
//        } else {
//            -age.compareTo(other.age)
//        }
//    }
}

fun main() {
    maxHeap()
    minHeap()
}

private fun maxHeap() {
    val pq = PriorityQueue<Man>() // age Max Heap
    pq.add(Man(10, 1, "jys"))
    pq.add(Man(20, 0, "unluckyjung"))
    pq.add(Man(20, 2, "goodall"))
    pq.add(Man(15, -1, "yoonsung"))
    pq.add(Man(15, 10, "fortune"))

    while (!pq.isEmpty()) {
        println(pq.remove())
    }

/*  Man(age=20, grade=0, name=unluckyjung)
    Man(age=20, grade=2, name=goodall)
    Man(age=15, grade=-1, name=yoonsung)
    Man(age=15, grade=10, name=fortune)
    Man(age=10, grade=1, name=jys)
    */
}

private fun minHeap() {
    val list = listOf(Man(20, 0, "unluckyjung"), Man(10, 1, "jys"))

    // 나이가 적을수록 우선순위
    minHeap1(list)
    println()
    minHeap2(list)
    println()
    minHeap3(list)
    println()

/*  Man(age=10, grade=1, name=jys)
    Man(age=20, grade=0, name=unluckyjung)
    */
}

private fun minHeap1(list: List<Man>) {
    val pq = PriorityQueue(
        Comparator<Man> { m1, m2 ->
            m1.age.compareTo(m2.age)
        }
    )
    pq.addAll(list)

    while (!pq.isEmpty()) {
        println(pq.remove())
    }
}

private fun minHeap2(list: List<Man>) {
    val pq = PriorityQueue(
        compareBy<Man> {
            it.age
        }
    )
    pq.addAll(list)

    while (!pq.isEmpty()) {
        println(pq.remove())
    }
}

private fun minHeap3(list: List<Man>) {
    val pq = PriorityQueue { m1: Man, m2: Man ->
        m1.age.compareTo(m2.age)
    }
    pq.addAll(list)

    while (!pq.isEmpty()) {
        println(pq.remove())
    }
}
