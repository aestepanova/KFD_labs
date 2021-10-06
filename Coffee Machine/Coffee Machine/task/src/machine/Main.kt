package machine

class CoffeeMachine {
    var water = 400
    var milk = 540
    var coffee = 120
    var cups = 9

    var cash = 550

    private var state = States.OFF

    private val offerActionsString = "\nWrite action (buy, fill, take, remaining, exit): "
    private val offerCoffeeString =
        "\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "

    enum class Actions(val str: String) {
        NULL(""),
        BUY("buy"),
        FILL("fill"),
        TAKE("take"),
        REMAINING("remaining"),
        EXIT("exit")
    }

    enum class Coffee(val type: String) {
        NULL(""),
        ESPRESSO("1"),
        LATTE("2"),
        CAPPUCCINO("3"),
        BACK("back")
    }

    enum class States(val str: String = "") {
        OFF(""),
        CHOOSE_ACTION("choosing an action"),
        MAKING_COFFEE("choosing a variant of coffee"),
        FILLING("fill the coffee machine"),
        FILLING_WATER("add water"),
        FILLING_MILK("add milk"),
        FILLING_COFFEE("add coffee"),
        FILLING_CUPS("add cups");
    }

    private fun buy() {
        state = States.MAKING_COFFEE
        print(offerCoffeeString)
    }

    private fun resourcesIsEnough(type: String, water: Int, milk: Int, coffee: Int, cups: Int): Boolean {
        when (type) {
            "1" -> {
                if (water < 250) {
                    print("Sorry, not enough water!")
                    return false
                }
                if (coffee < 16) {
                    print("Sorry not enough coffee beans")
                    return false
                }
                if (cups < 1) {
                    print("Sorry, not enough disposable cups!")
                    return false
                }
            }
            "2" -> {
                if (water < 350) {
                    print("Sorry, not enough water!")
                    return false
                }
                if (milk < 75) {
                    print("Sorry, not enough milk!")
                    return false
                }
                if (coffee < 20) {
                    print("Sorry not enough coffee beans")
                    return false
                }
                if (cups < 1) {
                    print("Sorry, not enough disposable cups!")
                    return false
                }
            }
            "3" -> {
                if (water < 200) {
                    print("Sorry, not enough water!")
                    return false
                }
                if (milk < 100) {
                    print("Sorry, not enough milk!")
                    return false
                }
                if (coffee < 12) {
                    print("Sorry not enough coffee beans")
                    return false
                }
                if (cups < 1) {
                    print("Sorry, not enough disposable cups!")
                    return false
                }
            }
        }
        print("I have enough resources, making you a coffee!")
        return true
    }

    private fun makeCoffee(coffeeType: String) {
        when (coffeeType) {
            Coffee.BACK.type -> {
                state = States.CHOOSE_ACTION
            }
            Coffee.ESPRESSO.type -> {
                state = States.MAKING_COFFEE
                if (resourcesIsEnough(Coffee.ESPRESSO.type, water, milk, coffee, cups)) {
                    water -= 250
                    coffee -= 16
                    cups -= 1
                    cash += 4

                }
            }
            Coffee.LATTE.type -> {
                state = States.MAKING_COFFEE
                if (resourcesIsEnough(Coffee.LATTE.type, water, milk, coffee, cups)) {
                    water -= 350
                    milk -= 75
                    coffee -= 20
                    cups -= 1

                    cash += 7
                }
            }
            Coffee.CAPPUCCINO.type -> {
                state = States.MAKING_COFFEE
                if ((resourcesIsEnough(Coffee.CAPPUCCINO.type, water, milk, coffee, cups))) {
                    water -= 200
                    milk -= 100
                    coffee -= 12
                    cups -= 1

                    cash += 6
                }
            }
        }

        print(offerActionsString)
        state = States.CHOOSE_ACTION

    }

    private fun fillCups(num: String) {
        val add = num.toInt()
        cups += add

        print(offerActionsString)
        state = States.CHOOSE_ACTION
    }

    private fun fillCoffee(g: String) {
        val add = g.toInt()
        coffee += add

        print("Write how many disposable cups of coffee do you want to add: ")
        state = States.FILLING_CUPS
    }

    private fun fillMilk(ml: String) {
        val add = ml.toInt()
        milk += add

        print("Write how many grams of coffee beans do you want to add: ")
        state = States.FILLING_COFFEE
    }

    private fun fillWater(ml: String) {
        val add = ml.toInt()
        water += add

        print("Write how many ml of milk do you want to add: ")
        state = States.FILLING_MILK
    }

    private fun fill() {
        print("\nWrite how many ml of water do you want to add: ")
        state = States.FILLING_WATER
    }

    private fun take() {
        print("I gave you $$cash")
        cash = 0

        print(offerActionsString)
        state = States.CHOOSE_ACTION
    }

    private fun remaining() {
        print(
            "\nThe coffee machine has\n$water of water\n$milk of milk\n" +
                    "$coffee of coffee beans\n$cups of disposable cups\n$$cash of money\n"
        )
        print(offerActionsString)
        state = States.CHOOSE_ACTION
    }

    private fun exit() {
        state = States.OFF
    }

    fun takeAction(s: String) {
        when (state) {
            States.OFF -> {
                print(offerActionsString)
                state = States.CHOOSE_ACTION
            }
            States.CHOOSE_ACTION -> {
                when (s) {
                    Actions.BUY.str -> buy()
                    Actions.FILL.str -> fill()
                    Actions.TAKE.str -> take()
                    Actions.REMAINING.str -> remaining()
                    Actions.EXIT.str -> exit()
                }
            }
            States.MAKING_COFFEE -> makeCoffee(s)
            States.FILLING_WATER -> fillWater(s)
            States.FILLING_MILK -> fillMilk(s)
            States.FILLING_COFFEE -> fillCoffee(s)
            States.FILLING_CUPS -> fillCups(s)
            else -> {
            }
        }
    }
}

fun main() {
    val Machine = CoffeeMachine()
    var action = ""
    do {
        Machine.takeAction(action)
        action = readLine()!!
    } while (action != "exit")
}