fun main() {
    val n = readLine()!!.toInt()
    var larger = 0
    var smaller = 0
    var perfect = 0
    repeat (n) {
       when (readLine()!!.toInt()) {
           1 -> larger += 1
           -1 -> smaller += 1
           0 -> perfect += 1
       }
    }

    println("$perfect $larger $smaller")
}