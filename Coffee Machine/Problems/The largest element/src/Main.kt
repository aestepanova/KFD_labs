fun main() {
    var max = 0
    do {
        val num = readLine()!!.toInt()
        if (num > max) max = num
    } while (num > 0)

    println(max)

}