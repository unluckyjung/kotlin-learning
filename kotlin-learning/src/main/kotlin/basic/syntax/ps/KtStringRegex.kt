package basic.syntax.ps

fun main() {
    val str = "JungYoonSung"
    println(str.matches(Regex("JungYoonSung"))) // true
    println(str.matches(Regex("unluckyJung"))) // false

    val numberRegex = Regex("\\d+")

    val str1 = "A1B2"
    println(numberRegex.containsMatchIn(str1))  // true (매칭되는 1, 2이 있음)
    println(numberRegex.matches(str1))  // false

    val matchNumber = numberRegex.find(str1)
    println(matchNumber?.value) // 앞의 1만 추출 // 1

    val matchNumbers = numberRegex.findAll(str1)
    matchNumbers.forEach {
        println(it.value)   // [1,2]
    }
}
