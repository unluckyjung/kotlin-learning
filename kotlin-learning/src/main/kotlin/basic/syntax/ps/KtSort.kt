package basic.syntax.ps

import java.time.ZonedDateTime

class KtSort {
}

data class SortMan(
    val age: Int,
    val grade: Int,
    val birthDayTime: ZonedDateTime = ZonedDateTime.now(),
)

fun main() {
    val mans = listOf(SortMan(30, 2), SortMan(10, 2), SortMan(20, 1), SortMan(20, 0))

    basicCompare(mans)
    multiCompare(mans)
}

private fun basicCompare(mans: List<SortMan>) {
    println("age 오름차순 정렬")
    val sortedMans1 = mans.sortedBy { it.age }
    sortedMans1.forEach {
        println(it.toString())
    }

    println("age 내림차순 정렬1")
    val sortedMans2 = mans.sortedBy { -it.age }
    sortedMans2.forEach {
        println(it.toString())
    }

    println("age 내림차순 정렬2")
    val sortedMans3 = mans.sortedByDescending { it.age }
    sortedMans3.forEach {
        println(it.toString())
    }
}

private fun multiCompare(
    mans: List<SortMan>,
) {
    println("age 오름차순 grade 내림차순")
    val sortedMans2 = mans.sortedWith(
        compareBy({ it.age }, { -it.grade }),
    )

    sortedMans2.forEach {
        println(it.toString())
    }

    println("age 오름차순 birthDayTime 내림차순")
    val sortedMans4 = mans.sortedWith(
        compareBy<SortMan> { it.age }.thenByDescending { it.birthDayTime },
    )

    sortedMans4.forEach {
        println(it.toString())
    }

    println("age 오름차순 birthDayTime 내림차순")
    val sortedMans5 = mans.sortedWith(
        Comparator<SortMan> { m1, m2 ->
            if (m1.age == m2.age) {
                -m1.birthDayTime.compareTo(m2.birthDayTime)
            } else {
                m1.age.compareTo(m2.age)
            }
        }
    )

    sortedMans5.forEach {
        println(it.toString())
    }
}