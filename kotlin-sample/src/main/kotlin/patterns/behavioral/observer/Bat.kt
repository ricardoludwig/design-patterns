package patterns.behavioral.observer

class Bat {

    fun screech() {
        println("Eeeeeee")
    }
    /*
    fun screech(message: Message) {
        when(message) {
            is HighMessage -> {
                for (i in 1..message.repeat) {
                    println("${message.pitch} Eeeeeee")
                }
            }
            else -> println("Can't :( ")
        }
    }
    */
}
