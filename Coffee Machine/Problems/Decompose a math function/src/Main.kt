fun f(x: Double): Double {

    return when {
        (x <= 0.0) -> f1(x)
        (x < 1 && x > 0) -> f2(x)
        (x >= 1) -> f3(x)
        else -> 0.0
    }

}

// implement your functions here
fun f1(x: Double) : Double {
    return x * x + 1.0
}

fun f2(x: Double) : Double {
    return 1/(x * x)
}

fun f3(x: Double) : Double {
    return x * x - 1
}