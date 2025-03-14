package patterns.structural.bridge

class Flamethrower: Weapon {
    override fun attack() = RIFLE_DAMAGE * 2
}
