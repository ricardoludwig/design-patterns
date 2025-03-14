package patterns.behavioral.observer

class Dog {

    fun bark() {
        println("Woof")
    }

    fun howl() {
        println("Awooooo")
    }

    /*
    fun bark(message: Message) {
        when(message) {
            is LowMessage -> {
                for (i in 1..message.repeat) {
                    println("${message.pitch} Woof")
                }
            }
            else -> println("Can't :( ")
        }
    }

    fun howl(message: Message) {
        when(message) {
            is HighMessage -> {
                for (i in 1..message.repeat) {
                    println("${message.pitch} Woof")
                }
            }
            else -> println("Can't :( ")
        }
    }
    */
}
