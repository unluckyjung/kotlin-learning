//package fast_io
//
//import java.io.FileInputStream
//import java.util.*
//
//val output = StringBuilder()
//
//fun main() {
//    val dirPath = System.getProperty("user.dir")
//    System.setIn(FileInputStream("$dirPath/kotlin-learning/src/main/kotlin/fast_io/input.txt"))
//
//    var input = StringTokenizer(readln())
//
//    val a = input.nextToken().toInt()
//    val b = input.nextToken().toInt()
//
//    val sum = a + b
//    output.append(sum)
//
//    println(output.toString())
//}
