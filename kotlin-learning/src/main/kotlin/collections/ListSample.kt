package collections

fun main() {
    numbers1()
    numbers2()
}

private fun numbers2() {
    val numbers2 = Numbers2()
    numbers2.add(1)
    numbers2.add(2)

    val list1 = numbers2.numbers
    println(list1.toString())   // [1, 2]

    numbers2.add(3)

    val list2 = numbers2.numbers
    println(list1.toString())    // [1, 2]
    println(list2.toString())    // [1, 2, 3]
}

private fun numbers1() {
    val numbers1 = Numbers1()
    numbers1.add(1)
    numbers1.add(2)

    val list1 = numbers1.numbers
    println(list1.toString())   // [1, 2]

    numbers1.add(3)

    val list2 = numbers1.numbers
    println(list1.toString())    // [1, 2]
    println(list2.toString())    // [1, 2, 3]
}


// numbers 만열어두고, numbers는 _numbers 를 내보내는 역할만 진행
class Numbers1 {
    private val _numbers: MutableList<Int> = mutableListOf()

    val numbers: List<Int>
        get() = _numbers.toList()

    fun add(num: Int) {
        _numbers.add(num)
    }
}


// add 때마다 방어적 복사
class Numbers2 {
    var numbers = listOf<Int>()
        private set

    fun add(num: Int) {
        numbers = numbers.plus(num)
    }
}

