package docs.basic.syntax

fun main() {
    printFun()
    println(sum(3, 5))  // 8
    println(multiply(3, 5)) // 15

    // nickName = 을 생략할 수 있다.
    printNickName(nickName = "goodall") // yoonsung nickName is goodall
    printSum(3, 7)  // sum of 3 and 7 is 10

    helloLanguage() // hello kotlin
    helloLanguage("java")   // hello java

    println(returnNull())

    // == return Nothing functions ==
//    infiniteLoop()
//    throwException()
//    infiniteLoop()
//    canReturnNull(true)

    val num1: Int = 1
    val num2 = 2
    val num3: Int
    num3 = sum(num1, num2)

    val finalNum: Int = 10;
    // finalNum = 11;  // val 변경불가능

    var changeNum = 20
    changeNum = 15  // 가능
}

private fun printFun() {
    println("hello kotlin")
    print("jung ")
    print("yoonsung ")
    println(30)
}

// 반환타입이 맨 뒤에 붙는다. (): Int
fun sum(num1: Int, num2: Int): Int {
    return num1 + num2
}

// 추론가능한 타입은 생략가능
fun multiply(num1: Int, num2: Int) = num1 * num2;

fun printNickName(nickName: String) {
    println("yoonsung nickName is $nickName")
}

// Unit을 생략할 수 있다.

// Unit, Void, Nothing 차이 정리하기 (https://stackoverflow.com/questions/55953052/kotlin-void-vs-unit-vs-nothing)
// Nothing (https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing.html)
// Nothing 추가 예시 (https://readystory.tistory.com/83?category=815287)
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

// 디폴트 값을 정해줄수 있다. (Default value: Kotlin)
fun helloLanguage(languageName: String = "Kotlin") {
    println("hello $languageName")
}

fun throwException(): Nothing {
    throw IllegalArgumentException()
}

// null을 리턴하려면 반환값은 Nothing? 을 사용한다.
fun returnNull(): Nothing? {
    return null
}

// Nothing?은 기본 Nothing에 Null을 같이 리턴할 수 있는 형태이다.
fun canReturnNull(flag: Boolean): Nothing? {
    if (flag) {
        throw IllegalArgumentException()
    } else {
        return null
    }
}

fun infiniteLoop(): Nothing {
    while (true) {
        println("Hi there!")
    }
}