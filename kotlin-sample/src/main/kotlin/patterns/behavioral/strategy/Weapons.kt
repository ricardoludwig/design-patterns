package patterns.behavioral.strategy

import patterns.behavioral.strategy.Direction

object Weapons {

    fun peashooter(x: Int, y: Int, direction: Direction) : Projectile {
        println("Peashooter")
        return Projectile(x, y, direction)
    }

    fun banana(x: Int, y: Int, direction: Direction) : Projectile {
        println("Banana boomerang")
        return Projectile(x, y, direction)
    }
}
