package patterns.structural.bridge

const val REGULAR_LEGS_SPEED:Meters = 1

class RegularLegs: Legs {
    override fun move() = REGULAR_LEGS_SPEED
}
