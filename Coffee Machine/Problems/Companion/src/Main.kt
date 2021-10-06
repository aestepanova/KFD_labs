class Player(val id: Int, val name: String, val speed: Int, val health: Int, val armor: Int) {
   companion object {
       var baseSpeed = 7
       var baseHealth = 100
       var baseArmor = 100
       var maxSpeed = 13
       var maxHealth = 140
       var maxArmor = 100
   }
}