package patterns.structural.bridge

data class StormTrooper(private val weapon: Weapon, private val legs: Legs) 
    : Trooper {

    override fun move(x: Long, y: Long) {
        legs.move()
    }

    override fun attackRebel(x: Long, y: Long) {
        weapon.attack()
    }
}
