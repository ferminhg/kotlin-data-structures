import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ScopeFunctionsTests {
    @Test
    fun `test let scope function`() {
        assertEquals("John",
            Person("John", 1.80).let { it.name })

        val stringList = listOf(1, 2, 3).let { list ->
            assertEquals(3, list.size)
            list.joinToString()
        }
        assertEquals("1, 2, 3", stringList)

        val numbers = mutableListOf("one", "two", "three", "four", "five")
        numbers.map { it.length }.filter { it > 3 }.let {
            assertEquals(3, it.size)
        }
    }

    @Test
    fun `test with scope function`() {
        val person = Person("John", 1.80)
        with(person) {
            assertEquals("John", name)
            assertEquals(1.80, height)
        }
    }
}
