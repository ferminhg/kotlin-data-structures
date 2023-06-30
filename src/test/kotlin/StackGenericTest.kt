import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StackGenericTest {
    @Test
    fun `LIFO and FILO should create an empty stack`() {
        val stackLIFO = StackGeneric<String>(StackType.LIFO)
        assertTrue(stackLIFO.isEmpty())
        assertNull(stackLIFO.top())

        val stackFILO = StackGeneric<String>(StackType.FILO)
        assertTrue(stackFILO.isEmpty())
        assertNull(stackFILO.top())
    }

    @Test
    fun `LIFO and FILO should push a value`() {
        val stackLIFO = StackGeneric<String>(StackType.LIFO)
        stackLIFO.push("value")
        assertFalse(stackLIFO.isEmpty())
        assertEquals("value", stackLIFO.top())

        val stackFILO = StackGeneric<String>(StackType.FILO)
        stackFILO.push("value")
        assertFalse(stackFILO.isEmpty())
        assertEquals("value", stackFILO.top())
    }

    @Test
    fun `LIFO should push a value and return the last one`() {
        val stackLIFO = StackGeneric<String>(StackType.LIFO)
        stackLIFO.push("value1")
        stackLIFO.push("value2")
        stackLIFO.push("value3")
        assertFalse(stackLIFO.isEmpty())
        assertEquals("value3", stackLIFO.top())
    }

    @Test
    fun `FILO should push a value and return the first one`() {
        val stackFILO = StackGeneric<String>(StackType.FILO)
        stackFILO.push("value1")
        stackFILO.push("value2")
        stackFILO.push("value3")
        assertFalse(stackFILO.isEmpty())
        assertEquals("value1", stackFILO.top())
    }

    @Test
    fun `LIFO should push a value and return the last one after pop`() {
        val stackLIFO = StackGeneric<String>(StackType.LIFO)
        stackLIFO.push("value1")
        stackLIFO.push("value2")
        stackLIFO.push("value3")
        assertFalse(stackLIFO.isEmpty())
        assertEquals("value3", stackLIFO.top())
        stackLIFO.pop()
        assertEquals("value2", stackLIFO.top())
    }


    @Test
    fun `FILO should push a value and return the first one after pop`() {
        val stackFILO = StackGeneric<String>(StackType.FILO)
        stackFILO.push("value1")
        stackFILO.push("value2")
        stackFILO.push("value3")
        assertFalse(stackFILO.isEmpty())
        assertEquals("value1", stackFILO.top())
        stackFILO.pop()
        assertEquals("value2", stackFILO.top())
    }


    @Test
    fun `LIFO should push a value and return the last one after pop all`() {
        val stackLIFO = StackGeneric<String>(StackType.LIFO)
        stackLIFO.push("value1")
        stackLIFO.push("value2")
        stackLIFO.push("value3")
        assertFalse(stackLIFO.isEmpty())
        assertEquals("value3", stackLIFO.top())
        stackLIFO.pop()
        assertEquals("value2", stackLIFO.top())
        stackLIFO.pop()
        assertEquals("value1", stackLIFO.top())
        stackLIFO.pop()
        assertNull(stackLIFO.top())
        assertTrue(stackLIFO.isEmpty())
    }


    @Test
    fun `FILO should push a value and return the first one after pop all`() {
        val stackFILO = StackGeneric<String>(StackType.FILO)
        stackFILO.push("value1")
        stackFILO.push("value2")
        stackFILO.push("value3")
        assertFalse(stackFILO.isEmpty())
        assertEquals("value1", stackFILO.top())
        stackFILO.pop()
        assertEquals("value2", stackFILO.top())
        stackFILO.pop()
        assertEquals("value3", stackFILO.top())
        stackFILO.pop()
        assertNull(stackFILO.top())
        assertTrue(stackFILO.isEmpty())
    }

}