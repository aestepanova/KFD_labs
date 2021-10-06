enum class Rainbow(val color: String, val rgb: String) {
    NULL("", ""),
    RED("red", "#FF0000"),
    ORANGE("orange", "#FF7F00"),
    YELLOW("yellow", "#FFFF00"),
    GREEN("green", "#00FF00"),
    BLUE("blue", "#0000FF"),
    INDIGO("indigo", "#4B0082"),
    VIOLET("violet", "#8B00FF");

    companion object {
        fun findByColor(color: String): Rainbow {
            for (enum in Rainbow.values()) {
                if (color == enum.color) return enum
            }
            return NULL
        }
    }
}

fun main() {
    val color = readLine()!!

    print(Rainbow.findByColor(color).ordinal)
}