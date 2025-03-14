package patterns.behavioral.state

object Still: Mood() {
    override fun draw() {
        println("Still mood")
    }
}
