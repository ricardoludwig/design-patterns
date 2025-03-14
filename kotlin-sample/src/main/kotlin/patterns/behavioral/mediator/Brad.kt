package patterns.behavioral.mediator

class Brad(private val productManager: ProductManager) : QA, Parrot {

    override fun doesMyCodeWork(): Boolean {
        return true
    }

    override fun isEating(): Boolean {
        return false
    }

    override fun isSleeping(): Boolean {
        return false
    }
}
