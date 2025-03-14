package patterns.behavioral.state

class Snail: WhatCanHappen {
    
    private var healthPoins = 10
    private var mood: Mood = Still

    override fun seeHero() {
        mood = when (mood) {
            is Still -> Agressive
            is Agressive -> Retreating 
            is Retreating -> Dead
            is Dead -> {
                println("Snail is dead")
                mood
            }
        }
        println("Snail is ${mood.javaClass.simpleName}")
    }

    override fun getHit(pointsOfDamage: Int) {
        println("Snail gets hit by $pointsOfDamage points")
    }

    override fun calmAgain() {
        println("Snail is calm again")
    }
}
