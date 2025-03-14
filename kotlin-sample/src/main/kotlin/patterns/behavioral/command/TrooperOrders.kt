package patterns.behavioral.command

open class TrooperOrders {
    private val orders = mutableListOf<Command>()

    fun addOrder(order: Command) {
        orders.add(order)
    }

    fun executeOrders() {
        while (orders.isNotEmpty()) {
            val order = orders.removeFirst()
            order()
        }
    }

    fun move(x: Int, y: Int) {
        println("Moving to $x, $y")
    }
}

typealias Command = () -> Unit

val moveGenerator = fun (s: TrooperOrders, x: Int, y: Int): Command {
    return {
        s.move(x, y)
    }
}
