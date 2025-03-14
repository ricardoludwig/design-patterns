package patterns.structural.bridge

typealias PointsOfDamage = Long

interface Weapon {
    fun attack(): PointsOfDamage
}
