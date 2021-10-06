fun findPrice(old: Int = 5, passed: Int = 100000, speed: Int = 120, auto: Int = 0) : Int {

    var price = 20000
    price -= 2000 * old
    price += (speed - 120) * 100
    price -= 200 * (passed / 10000)
    if (auto == 1) price += 1500

    return price
}



fun main(args: Array<String>) {
    val parameter = readLine()!!
    val num = readLine()!!.toInt()

    when (parameter) {
        "old" -> println(findPrice(old = num))
        "passed" -> println(findPrice(passed = num))
        "speed" -> println(findPrice(speed = num))
        "auto" -> println(findPrice(auto = num))
    }

}