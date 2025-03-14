package patterns.behavioral.observer

class Turkey {
    fun gooble() {
        println("Gobble-gobble")
    }
/*
    fun gooble(message: Message) {
        when(message) {
            is LowMessage -> {
                for (i in 1..message.repeat) {
                    println("${message.pitch} Gobble-gobble")
                }
            }
            else -> println("Can't :( ")
        }
    }
*/
}
