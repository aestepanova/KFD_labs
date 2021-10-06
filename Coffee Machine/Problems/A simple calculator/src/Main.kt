fun main() {

    val (a, op, b) = readLine()!!.split(" ")

    val firstNumber = a.toLong()
    val secondNumber = b.toLong()

    when (op) {
        "+" -> print(firstNumber + secondNumber)
        "-" -> print(firstNumber - secondNumber)
        "*" -> print(firstNumber * secondNumber)
        "/" -> {
            if (secondNumber == 0L) print("Division by 0!")
            else print(firstNumber / secondNumber)
        }
        else -> print("Unknown operator")
    }
}