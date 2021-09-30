fun sum(vararg sm : Int) {sm.sum()}

fun main(){
    println("\n\nHi, Kotlin!")
    println("2\t32")
    var a = "too many friends"
    a = "try"
    println(a)
    val t = 8
    println(t)

    arrayOfNulls<Int>(5).forEach {
        println(it)
    }
    val cat = String("Cat".toCharArray())
    val cat2 = cat.plus("Shurik")
    println(cat)
    println(cat2)

    val str = "Zvezdochka rulit"
    for (c in str){
        println(c)
    }
    val i = str.get(6).toString().plus(str[4])
    println(i)

}

// vararg
//что такое нативный код native code
//что такое null безопасен
//domen language
// тест котлин басик, тест по спрингу, тест по фронтендовой части
// защита проектов - придумать сервис в декабре
// до декабря изучим бэкэнд
// Jet Brains tool box
// байткод что это
//repl
//jdk, jvm, jvr
//