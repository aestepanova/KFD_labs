fun divide(a: Long, b: Long): Double {
    return a.toDouble() / b.toDouble()
}

fun main() {
    val a = readLine()!!.toLong()
    val b = readLine()!!.toLong()
    println(divide(a, b))
}