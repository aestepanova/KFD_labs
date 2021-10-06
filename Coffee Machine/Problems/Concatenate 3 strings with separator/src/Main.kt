fun concatenate(a: String, b: String, c: String, separator: String = " ") : String {
    return a + separator + b + separator + c
}

fun main() {
    val a = readLine()!!
    val b = readLine()!!
    val c = readLine()!!
    val sep = readLine()!!
    if (sep == "NO SEPARATOR") {
        println(concatenate(a, b, c))
    }
    else println(concatenate(a, b, c, separator = sep))
}