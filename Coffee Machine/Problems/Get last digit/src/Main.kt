import kotlin.math.absoluteValue

fun getLastDigit(a: Int): Int {
    return a.absoluteValue % 10
}

fun main() {
    val a = readLine()!!.toInt()
    println(getLastDigit(a))
}