enum class Rainbow(val color: String, val rgb: String) {
    RED("red", "#FF0000"),
    ORANGE("orange", "#FF7F00"),
    YELLOW("yellow", "#FFFF00"),
    GREEN("green", "#00FF00"),
    BLUE("blue", "#0000FF"),
    INDIGO("indigo", "#4B0082"),
    VIOLET("violet", "#8B00FF");
}

fun check(color: String): Boolean {
    for (rColor in Rainbow.values()){
        if (color == rColor.color) return true
    }
    return false
}

fun main() {
    val col = readLine()!!
    println(check(col))
}