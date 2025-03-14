package patterns.behavioral.mediator

class Kenny(private val productManager: ProductManager) : QA, Parrot {

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
