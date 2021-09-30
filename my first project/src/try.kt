fun baby(vararg sm: Int){
    val rep = '1'
    val toto = 21324
    println(rep.toString()+toto.toString())
    println(toto+rep.toInt())

    for(it in sm){
        println(it)
    }
}

fun main(){
    baby(456, 654, 5555, 111)
}