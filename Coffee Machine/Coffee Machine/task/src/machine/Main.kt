package machine

fun main() {
    /*println("Starting to make a coffee")
    println("Grinding coffee beans")
    println("Boiling water")
    println("Mixing boiled water with crushed coffee beans")
    println("Pouring coffee into the cup")
    println("Pouring some milk into the cup")
    println("Coffee is ready!")*/
    println("Write how many ml of water the coffee machine has:")
    var water = readLine()!!.toInt()
    println("Write how many ml of milk the coffee machine has:")
    var milk = readLine()!!.toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    var coffee = readLine()!!.toInt()
    println("Write how many cups of coffee you will need: ")
    val cups = readLine()!!.toInt()

    /*   println("For" + cups.toString() + "cups of coffee you will need:") 300, 65, 111, 1
       println((200 * cups).toString() + "ml of water")
       println((50 * cups).toString() + "ml of milk")
       println((15 * cups).toString() + "g of coffee beans")*/

    if ((200 * cups <= water) && (50 * cups <= milk) && (15 * cups <= coffee)) {
        print("Yes, I can make that amount of coffee")

        water -= 200 * cups
        milk -= 50 * cups
        coffee -= 15 * cups

        val addCups = minOf(water / 200, milk / 50, coffee / 15)

        if (addCups > 0) println("and even $addCups more than that")
    } else {

        val onlyCups = minOf(water / 200, milk / 50, coffee / 15)
        println("No, I can make only $onlyCups cups of coffee")
    }
}
