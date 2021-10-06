fun main() {
    val n = readLine()!!.toInt()
    var D = 0
    var C = 0
    var B = 0
    var A = 0
    repeat (n) {
        when (readLine()!!.toInt()) {
            2 -> D += 1
            3 -> C += 1
            4 -> B += 1
            5 -> A += 1
        }
    }

    println("$D $C $B $A")
}