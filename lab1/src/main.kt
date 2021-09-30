import java.io.File
import kotlin.math.max

/*Реализуйте бинарное дерево поиска для целых чисел. Программа получает на вход
последовательность целых чисел и строит из них дерево. Элементы в деревья
добавляются в соответствии с результатом поиска их места. Если элемент уже существует
в дереве, добавлять его не надо. Балансировка дерева не производится.
На вход программа получает последовательность натуральных чисел. Последовательность
завершается числом 0, которое означает конец ввода, и добавлять его в дерево не надо.
Для полученного дерева выведите список всех вершин, имеющих по два ребёнка, в
порядке возрастания.*/


typealias Visitor<T> = (T) -> Unit


class Node<T>(val value: T){

    var leftChild: Node<T>? = null
    var rightChild: Node<T>? = null

    override fun toString() = diagram(this)
    private fun diagram(node: Node<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun returnParents(visit: Visitor<T>){
        leftChild?.returnParents(visit)
        if (leftChild != null && rightChild != null){
            visit(value)
        }
        rightChild?.returnParents(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    fun height(node: Node<T>? = this): Int {
        return node?.let { 1 + max(height(node.leftChild), height(node.rightChild)) } ?: -1
    }
}



class BinarySearchTree<T: Comparable<T>>() {
    var root: Node<T>? = null
    override fun toString() = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        if (value!=0) root = insert(root, value)
    }
    private fun insert(
        node: Node<T>?,
        value: T
    ):Node<T> {
        node ?: return Node(value)
        if (this.contains(value)){
            println("This node already exists!")
            return node
        }
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        return node
    }

    fun contains(value: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }

}


fun readFile(tree: BinarySearchTree<Int>): BinarySearchTree<Int>{
    println("Please, enter name of a file: ")
    val fn = readLine()!!
    for (line in File(fn).readLines()) {
        val node = line.toInt()
        tree.insert(node)
    }
    return tree
}

fun main() {
    val myTree = BinarySearchTree<Int>()
    var el = 1
    println("Enter your nodes ---> ")
    do {
        try {
            el = readLine()!!.toInt()
            myTree.apply { insert(el) }
        } catch (e: NumberFormatException) {
            println("Program raised an exception" + e.message)
        }
    } while (el != 0)
    //readFile(myTree)

    println(myTree)

    myTree.root?.traverseInOrder { println(it) }

    println()
    val nodes = arrayListOf<Int>()
    myTree.root?.returnParents {nodes.add(it)}
    for ((i, each) in nodes.withIndex()){
        println("[$i] = $each")
    }
}

