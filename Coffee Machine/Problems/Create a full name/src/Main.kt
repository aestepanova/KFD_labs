// use this code as a source of inspiration for your function
fun getFullNames() {
    val firstName1 = readLine()!!
    val lastName1 = readLine()!!
    println(createFullName(firstName1, lastName1))

    val firstName2 = readLine()!!
    val lastName2 = readLine()!!
    println(createFullName(firstName2, lastName2))
}

// implement your function here
fun createFullName(firstName: String, secondName: String) : String{
    return (firstName + " " + secondName)
}