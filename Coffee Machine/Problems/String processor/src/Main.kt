fun main() {
    val s1 = readLine()!!
    val s2 = readLine()!!
    val s3 = readLine()!!

    when (s2) {
        "equals" -> println(s1 == s3)
        "plus" -> println(s1 + s3)
        "endsWith" -> println(s1.endsWith(s3))
        else -> println("Unknown operation")
    }
}