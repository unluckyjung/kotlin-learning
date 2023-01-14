package basic.syntax.ps

fun main() {
    mapDescending()
    mapGetOrDefault()
    mapList()
}

private fun mapList() {
    val m = mutableMapOf(
        3 to mutableListOf(30)
    )

    m[0]?.add(0) ?: run {
        m[0] = mutableListOf(0)
    }

    m[1]?.let {
        it.add(10)
    } ?: run {
        m[1] = mutableListOf(10)
    }

    // 가독성은 아래가 좋지만, m[1]?.add 와 같이 호출해야한다.
    // if null check는 다른 스레드에서 값을 변경할 수 있기 때문이다.
    if (m[2].isNullOrEmpty()) {
        m[2] = mutableListOf(20)
    } else {
        m[2]?.add(20)
    }

    println(m)  // {3=[30], 0=[0], 1=[10], 2=[20]}
}

private fun mapGetOrDefault() {
    val m = mutableMapOf<Int, Int>()
    m[1] = m.getOrDefault(1, 0) + 10
    m[1] = m.getOrDefault(1, 0) + 20
    println(m[1])   // 30
}

private fun mapDescending() {
    val m = mutableMapOf(
        1 to "jys",
        3 to "yoonsung",
        2 to "unluckyjung",
    )

    m.toSortedMap(compareByDescending { it }).forEach { (number, name) ->
        println("$number and $name")
    }
}
