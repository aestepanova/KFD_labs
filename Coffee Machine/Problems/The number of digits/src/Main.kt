fun main() {
    val a = readLine()!!.toInt()

    when {
        a > 999 -> print(4)
        a > 99 -> print(3)
        a > 9 -> print(2)
        else -> print(1)
    }
}