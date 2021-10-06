fun main() {
    val n = readLine()!!.toInt()
    var larger = 0
    var num: Int
    repeat (n) {
        num = readLine()!!.toInt()
        if (num > 0) larger += 1
    }

    println(larger)
}