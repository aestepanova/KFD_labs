import kotlin.math.pow

fun finalAmount(amount : Int = 1000, yearlyPercent: Int = 5, years: Int = 10) : Int {
    val tmp = (1 + yearlyPercent.toDouble() / 100)
    return (amount * tmp.pow(years)).toInt()
}

fun main() {
    val parameter = readLine()!!
    val num = readLine()!!.toInt()

    when (parameter) {
        "amount" -> print(finalAmount(amount = num))
        "percent" -> print(finalAmount(yearlyPercent = num))
        "years" -> print(finalAmount(years = num))
    }
}