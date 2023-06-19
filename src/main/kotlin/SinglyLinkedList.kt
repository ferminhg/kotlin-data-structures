
class Node(val data: Int) {
    var next: Node? = null
}

class SinglyLinkedList {
    private var list: Node? = null
    fun insertAtEnd(data: Int) {
        val node = Node(data)

        list?.let {
            var current = it
            while (current.next != null) {
                current = current.next!!
            }
            current.next = node
        } ?: run {
            list = node
        }
    }

    fun insertAtHead(data: Int) {
        val node = Node(data)
        node.next = list
        list = node
    }
    fun isEmpty(): Boolean {
        return list == null
    }

    fun deleteAtHead() {
        list = list?.next
    }

    fun deleteAtEnd(){
        var current = list
        var previous: Node? = current
        while (current?.next != null) {
            previous = current
            current = current.next
        }

        if (previous == current) {
            list = null
            return
        }
        previous?.next = null
    }
    override fun toString(): String {
        var current = list
        val arrayList = arrayListOf<Int>()

        while (current != null) {
            arrayList.add(current.data)
            current = current.next
        }
        return arrayList.joinToString(" -> ")
    }
}
