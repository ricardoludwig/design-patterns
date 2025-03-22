package patterns.creational.singleton

class SingletonHolder private constructor(private val data: String) {

    companion object {
        @Volatile
        private var instance: SingletonHolder? = null

        fun getInstance(value: String): SingletonHolder =
            instance ?: synchronized(this) {
                instance ?: SingletonHolder(value).also { instance = it }
            }
        //Add this method for testing purposes
        fun reset() {
            instance = null
        }
    }

    fun getData(): String = data

}