import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SinglyLinkedListUniTest {
    @Test
    fun testInsertAtHead() {
        val list = SinglyLinkedListUni()
        list.insertAtHead(1)
        assertEquals("1", list.toString())


        list.insertAtHead(2)
        assertEquals("2 <-> 1", list.toString())

        list.insertAtHead(3)
        list.insertAtHead(4)
        list.insertAtHead(5)
        assertEquals("5 <-> 4 <-> 3 <-> 2 <-> 1", list.toString())
    }

    @Test
    fun testInsertAtEnd() {
        val list = SinglyLinkedListUni()
        list.insertAtEnd(1)
        assertEquals("1", list.toString())

        list.insertAtEnd(2)
        assertEquals("1 <-> 2", list.toString())

        list.insertAtEnd(3)
        list.insertAtEnd(4)
        list.insertAtEnd(5)
        assertEquals("1 <-> 2 <-> 3 <-> 4 <-> 5", list.toString())
    }

    @Test
    fun testDeleteAtHead() {
        val list = SinglyLinkedListUni()
        list.insertAtEnd(1)
        list.insertAtEnd(2)
        list.insertAtEnd(3)
        list.insertAtEnd(4)
        list.insertAtEnd(5)
        assertEquals("1 <-> 2 <-> 3 <-> 4 <-> 5", list.toString())
        list.deleteAtHead()
        assertEquals("2 <-> 3 <-> 4 <-> 5", list.toString())
        list.deleteAtHead()
        assertEquals("3 <-> 4 <-> 5", list.toString())
    }

    @Test
    fun testDeleteAtEnd() {
        val list = SinglyLinkedListUni()
        list.insertAtEnd(1)
        list.deleteAtEnd()
        assertEquals("", list.toString())

        list.insertAtEnd(1)
        list.insertAtEnd(2)
        list.insertAtEnd(3)
        list.insertAtEnd(4)
        list.insertAtEnd(5)
        list.deleteAtEnd()
        assertEquals("1 <-> 2 <-> 3 <-> 4", list.toString())
    }
}
