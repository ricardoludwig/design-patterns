package patterns.creational.singleton

import kotlin.test.Test
import kotlin.test.assertSame

class SingletonHttpClientTest {

    @Test
    fun `verify singleton instance is always the same`() {
        val instance1 = SingletonHttpClient
        val instance2 = SingletonHttpClient

        assertSame(instance1, instance2, "Singleton instances should be the same")
    }
}
