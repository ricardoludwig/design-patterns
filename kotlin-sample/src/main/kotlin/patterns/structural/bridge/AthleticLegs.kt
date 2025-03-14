package patterns.structural.bridge

class AthleticLegs: Legs {
    override fun move() = REGULAR_LEGS_SPEED * 2
}
