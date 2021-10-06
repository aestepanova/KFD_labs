class Player(val id: Int, val name: String, val hp: Int) {
    companion object{
        var k = 17
        fun create(name: String): Player {
            k++
            return Player(k, name, 100)
        }
    }
}