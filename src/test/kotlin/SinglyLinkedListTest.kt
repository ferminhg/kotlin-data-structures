import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SinglyLinkedListTest {

    @Test
    fun `test insertAtEnd`() {
        val list = SinglyLinkedList()
        assertTrue(list.isEmpty())

        list.insertAtEnd(1)
        assertFalse(list.isEmpty())
        list.insertAtEnd(2)
        assertEquals("1 -> 2", list.toString())
    }

    @Test
    fun `test insertAtHead`() {
        val list = SinglyLinkedList()

        list.insertAtHead(1)
        assertEquals("1", list.toString())
        list.insertAtHead(2)
        assertEquals("2 -> 1", list.toString())
    }

    @Test
    fun `test deleteAtHead`() {
        val list = SinglyLinkedList()
        list.insertAtEnd(1)
        list.insertAtEnd(2)
        list.insertAtEnd(3)
        list.insertAtEnd(4)
        list.insertAtEnd(5)
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", list.toString())
        list.deleteAtHead()
        assertEquals("2 -> 3 -> 4 -> 5", list.toString())
        list.deleteAtHead()
        assertEquals("3 -> 4 -> 5", list.toString())
    }

    @Test
    fun `test deleteAtEnd`() {
        val list = SinglyLinkedList()
        list.insertAtEnd(1)
        list.deleteAtEnd()
        assertEquals("", list.toString())


        list.insertAtEnd(1)
        list.insertAtEnd(2)
        list.insertAtEnd(3)
        list.insertAtEnd(4)
        list.insertAtEnd(5)
        assertEquals("1 -> 2 -> 3 -> 4 -> 5", list.toString())
        list.deleteAtEnd()
        assertEquals("1 -> 2 -> 3 -> 4", list.toString())
        list.deleteAtEnd()
        assertEquals("1 -> 2 -> 3", list.toString())
    }
}