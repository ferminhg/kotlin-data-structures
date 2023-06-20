
class NodeUni(val data: Int) {
    var next: NodeUni ?= null
    var previous: NodeUni ?= null
}

class SinglyLinkedListUni {
    private var list: NodeUni ?= null

    fun insertAtHead(data: Int) {
        val node = NodeUni(data)
        node.next = list
        list = node
    }

    fun insertAtEnd(data: Int) {
        val node = NodeUni(data)

        list?.let {
            var current = it
            while (current.next != null) {
                current = current.next!!
            }
            node.previous = current
            current.next = node
        } ?: run {
            node.previous = null
            list = node
        }
    }

    fun deleteAtHead() {
        list = list?.next
    }

    fun deleteAtEnd() {
        var current = list
        var previous: NodeUni? = current
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
        return arrayList.joinToString(" <-> ")
    }
}