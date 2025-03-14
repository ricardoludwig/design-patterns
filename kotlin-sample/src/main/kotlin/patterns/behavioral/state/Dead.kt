package patterns.behavioral.state

object Dead: Mood() {
    override fun draw() {
        println("Dead mood")
    }
}
