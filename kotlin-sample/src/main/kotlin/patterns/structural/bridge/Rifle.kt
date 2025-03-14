package patterns.structural.bridge

const val RIFLE_DAMAGE = 10L

class Rifle: Weapon {
    override fun attack() = RIFLE_DAMAGE
}
