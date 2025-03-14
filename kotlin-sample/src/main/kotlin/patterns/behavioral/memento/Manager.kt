package patterns.behavioral.mediator

import kotlin.collections.mutableListOf

class Manager {

    private var thoughts = mutableListOf<String>()

    fun printThoughts() {
        println(thoughts)
    }

    inner class Memory(private val mindState: List<String>) {
        fun restore() {
            thoughts = mindState.toMutableList()
        }
    }

    fun saveThatThought(): Memory {
        return Memory(thoughts.toList())
    }

    fun `what was I thinking back then`(memory: Memory) {
        memory.restore()
    }

    fun think(thought: String) {
        thoughts.add(thought)
        if(thoughts.size > 2) {
            thoughts.removeFirst()
        }
    }
}
