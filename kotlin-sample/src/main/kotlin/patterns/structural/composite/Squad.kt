package patterns.structural.composite

import patterns.structural.bridge.Trooper
import patterns.behavioral.iterator.TrooperIterator

class Squad(private val units: List<Trooper>) : Trooper {

    constructor(vararg units: Trooper) : this(units.toList())

    operator fun iterator(): Iterator<Trooper> {
        return TrooperIterator(units)
    }

    override fun attackRebel(x: Long, y: Long) {
        units.forEach {
            it.attackRebel(x, y)
            println("Squad attack")
        }
    }

    override fun move(x: Long, y: Long) {
        units.forEach {
            it.move(x, y)
            println("Squad move")
        }
    }
}
