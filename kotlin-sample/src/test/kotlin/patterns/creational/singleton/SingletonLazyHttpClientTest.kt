package patterns.creational.singleton

import kotlin.test.Test
import kotlin.test.assertSame

class SingletonLazyHttpClientTest {

    @Test
    fun `verify singleton instance is always the same`() {
        val instance1 = SingletonLazyHttpClient.instance
        val instance2 = SingletonLazyHttpClient.instance

        assertSame(instance1, instance2, "Singleton instances should be the same")
    }
}
