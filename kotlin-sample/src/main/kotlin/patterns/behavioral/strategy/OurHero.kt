package patterns.behavioral.strategy

class OurHero {

    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173

    var currentWeapon = Weapons::peashooter
    val shoot =
            fun() {
                currentWeapon(x, y, direction)
            }
}
