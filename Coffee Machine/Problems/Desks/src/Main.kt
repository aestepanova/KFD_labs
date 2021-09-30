fun main() {
    // put your code here
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    val desks = a/2 + b/2 + c/2 + a%2 + b%2 + c%2
    println(desks)

}
