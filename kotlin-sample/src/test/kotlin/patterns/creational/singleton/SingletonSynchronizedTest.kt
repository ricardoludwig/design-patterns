package patterns.creational.singleton

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class SingletonSynchronizedTest {

    @BeforeEach
    fun setup() {
        SingletonSynchronized.reset()
    }

    @Test
    fun `test singleton returns same instance`() {
        val instance1 = SingletonSynchronized.getInstance("test")
        val instance2 = SingletonSynchronized.getInstance("different value")

        assertNotNull(instance1)
        assertNotNull(instance2)

        assertSame(instance1, instance2)

        assertEquals("test", instance1?.getData())
        assertEquals("test", instance2?.getData())

    }

    @Test
    fun `test singleton thread safety`() {
        val threadCount = 100
        val executor = Executors.newFixedThreadPool(threadCount)
        val instances = mutableListOf<SingletonSynchronized?>()

        // Create multiple threads that try to get the instance simultaneously
        repeat(threadCount) {
            executor.submit {
                val instance = SingletonSynchronized.getInstance("test$it")
                synchronized(instances) {
                    instances.add(instance)
                }
            }
        }

        // Shutdown executor and wait for all threads to complete
        executor.shutdown()
        executor.awaitTermination(5, TimeUnit.SECONDS)

        // Verify all instances are the same
        val firstInstance = instances.first()
        instances.forEach { instance ->
            assertSame(firstInstance, instance)
        }

        // Verify the data is from the first successful initialization
        assertTrue(firstInstance?.getData()?.startsWith("test") == true)
    }

    @Test
    fun `test singleton remains same after multiple calls`() {
        val firstInstance = SingletonSynchronized.getInstance("initial")

        // Try to create new instances multiple times
        repeat(5) {
            val nextInstance = SingletonSynchronized.getInstance("attempt$it")
            assertSame(firstInstance, nextInstance)
            assertEquals(firstInstance?.getData(), nextInstance?.getData())
        }
    }
}