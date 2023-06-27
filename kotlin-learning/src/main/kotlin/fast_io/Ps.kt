package fast_io

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.file.Paths
import java.util.*

fun main(){
    val path = Paths.get("")
    val dirPath = path.toAbsolutePath().toString()
    //    val dirPath = System.getProperty("user.dir")  // 위와 동일하게 경로를 얻어냄.
    System.setIn(FileInputStream("$dirPath/kotlin-learning/src/main/kotlin/fast_io/input.txt"))

    val count = readln().toInt()
    val sb = StringBuilder()

    repeat(count) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        sb.append(n + m).append("\n")
    }
    println(sb)
}

private fun useStringTokenizer() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(count) {
        // StringTokenizer 은 정규식처리하는 Split 보다 조금 더 빠르긴함.
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        sb.append(n + m).append("\n")
    }
    println(sb)
}

private fun useBufferedReader() {
    // BufferedReader 가 readLine 보다 조금더 빠르긴 함. 크게 차이없음.
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(count) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        sb.append(n + m).append("\n")
    }
    println(sb)
}

private fun use_readln() {
    // readln 은 내부적으로 readLine 을 사용
    val count = readln().toInt()
    val sb = StringBuilder()
    repeat(count) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        sb.append(n + m).append("\n")
    }
    println(sb)
}
