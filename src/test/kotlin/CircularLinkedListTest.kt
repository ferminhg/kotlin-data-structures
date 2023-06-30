import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CircularLinkedListTest {

    @Test
    fun `test add duplicate values`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.add(1)
        assertEquals(1, list.size())
        assertEquals(1, list.head?.value)
        assertEquals(1, list.tail?.value)
    }

    @Test
    fun `test add`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.add(1)
        list.add(2)
        list.add(3)
        assertEquals(3, list.size())
        assertEquals(1, list.head?.value)
        assertEquals(3, list.tail?.value)
    }

    @Test
    fun `test remove`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(2)
        assertEquals(2, list.size())
        assertEquals(1, list.head?.value)
        assertEquals(3, list.tail?.value)


        val listOnItem = CircularLinkedList<Int>()
        listOnItem.add(1)
        listOnItem.remove(2)
        assertEquals(1, listOnItem.size())
        assertEquals(1, listOnItem.head?.value)
    }

    @Test
    fun `test remove head`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(1)
        assertEquals(2, list.size())
        assertEquals(2, list.head?.value)
        assertEquals(3, list.tail?.value)
    }

    @Test
    fun `test remove tail`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(3)
        assertEquals(2, list.size())
        assertEquals(1, list.head?.value)
        assertEquals(2, list.tail?.value)
    }

    @Test
    fun `test remove all`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(1)
        list.remove(2)
        list.remove(3)
        assertEquals(0, list.size())
        assertNull(list.head)
        assertNull(list.tail)
    }

    @Test
    fun `test remove not found`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(4)
        assertEquals(3, list.size())
        assertEquals(1, list.head?.value)
        assertEquals(3, list.tail?.value)
    }

    @Test
    fun `test remove empty`() {
        val list = CircularLinkedList<Int>()
        list.remove(1)
        assertEquals(0, list.size())
        assertNull(list.head)
        assertNull(list.tail)
    }

    @Test
    fun `test remove one`() {
        val list = CircularLinkedList<Int>()
        list.add(1)
        list.remove(1)
        assertEquals(0, list.size())
        assertNull(list.head)
        assertNull(list.tail)
    }
}