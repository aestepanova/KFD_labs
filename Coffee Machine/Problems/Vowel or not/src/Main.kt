fun isVowel(a: Char): Boolean {

    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return a in vowels

}

fun main() {

    val letter = readLine()!!.first()
    println(isVowel(letter))

}