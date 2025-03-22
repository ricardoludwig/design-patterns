package patterns.creational.singleton

import kotlin.concurrent.Volatile

class SingletonSynchronized private constructor(private val data: String) {

    companion object {
        @Volatile
        private var instance: SingletonSynchronized? = null

        fun getInstance(value: String): SingletonSynchronized? {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = SingletonSynchronized(value)
                    }
                }
            }
            return instance
        }

        //Add this method for testing purposes
        fun reset() {
            synchronized(this) {
                instance = null
            }
        }
    }

    fun getData(): String = data
}
