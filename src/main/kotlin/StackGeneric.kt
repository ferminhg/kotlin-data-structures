
enum class StackType(val type: Int){
    LIFO(0),
    FILO(1)
}

class StackGeneric<T> (val type: StackType) {
    private var top: NodeStack<T>? = null
    private var valueList = mutableListOf<T>()

    fun isEmpty() = valueList.isEmpty()

    fun top(): T? = top?.value
    fun push(newValue: T) {
        valueList = if (type == StackType.LIFO) {
            mutableListOf(newValue).apply { addAll(valueList) }
        } else {
            valueList.apply { add(newValue) }
        }

        top = valueList.firstOrNull()?.let { NodeStack(it) }
    }


    fun pop() {
        valueList = if (type == StackType.LIFO) {
            valueList.drop(1).toMutableList()
        } else {
            valueList.dropLast(1).toMutableList()
        }

        top = valueList.firstOrNull()?.let { NodeStack(it) }
    }

}

class NodeStack<T>(val value: T)
