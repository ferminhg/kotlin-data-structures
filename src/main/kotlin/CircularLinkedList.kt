class NodeCircular<T>(val value:  T) {
    var next: NodeCircular<T>? = null
    var previous: NodeCircular<T>? = null
}

class CircularLinkedList<T> {
    var tail: NodeCircular<T> ?= null
    var head: NodeCircular<T> ?= null

    private var valueList = mutableListOf<T>()

    fun add(value: T) {
        if (valueList.contains(value)) return
        valueList.add(value)

        val node = NodeCircular(value)

        if (head == null) {
            node.next = node
            node.previous = node
            head = node
            tail = node
            return
        }

        val lastTail = tail

        node.next = head
        node.previous = lastTail
        lastTail!!.next = node
        head?.previous = node  // Actualizar el enlace previous del nodo head
        tail?.next = node      // Actualizar el enlace next del nodo tail
        tail = node
    }


    fun size() = valueList.size

    fun remove(value: T) {
        if (!valueList.contains(value)) return
        valueList.remove(value)

        var node = head
        while (!removeNode(node, value) && node != tail) {
            node = node?.next
        }
    }

    private fun removeNode(node: NodeCircular<T>?, value: T): Boolean {
        if (node!!.value != value) {
            return false
        }

        val previous = node.previous
        val next = node.next
        previous?.next = next
        next?.previous = previous
        if (node == head) head = next
        if (node == tail) tail = previous
        if (valueList.isEmpty()) {
            head = null
            tail = null
        }
        return true
    }


    override fun toString(): String {
        var node = head
        var result = ""
        while (node != tail) {
            result += "${node?.value}"
            node = node?.next
            if (node != tail) result += " <-> "
        }
        return result
    }

}