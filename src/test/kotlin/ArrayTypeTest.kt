import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArrayTypeTest {
    @Test
    fun `simple test to check if the array is created correctly`() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(5, array.size)

        // check if I can mutate the array
        array[0] = 10
        assertEquals(10, array[0])

        // check if I can add a new element to the array
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            array[5] = 6
        }
    }

    @Test
    fun `test remove actions on array`() {
        val arrayOne = intArrayOf(1, 2, 3, 4, 5)
        val arrayTwo = intArrayOf(6, 7, 8, 9, 10)

        // check if I can add two arrays together
        val arrayThree = arrayOne + arrayTwo
        assertEquals(10, arrayThree.size)

        // using filter to remove elements from an array
        val arrayFiltered = arrayThree.filter { !arrayTwo.contains(it) }.toIntArray()
        assertTrue(arrayFiltered contentEquals arrayOne)
        assertFalse(arrayFiltered contentEquals arrayTwo)

        //using toMutableList() function and removeAll()
        val mutableList = arrayThree.toMutableList()
        mutableList.removeAll(arrayTwo.toList())
        val mutableArray = mutableList.toTypedArray()
        assertTrue(mutableArray contentEquals arrayOne.toTypedArray())

        // using filterNot() to remove elements from an array
        val arrayFilteredNot = arrayThree.filterNot { arrayTwo.contains(it) }.toTypedArray()
        assertTrue(arrayFilteredNot contentEquals arrayOne.toTypedArray())
    }

    @Test
    fun `test slicing an array`() {
        val arrayData = intArrayOf(1, 2, 3, 4, 5)
        val arraySliced = arrayData.sliceArray(0..2)
        assertTrue(arraySliced contentEquals intArrayOf(1, 2, 3))

        // using take() function
        val arrayTake = arrayData.take(3).toIntArray()
        assertTrue(arrayTake contentEquals intArrayOf(1, 2, 3))

        //slicing an array using values
        val arrayFiltered = arrayData.filter { it % 2 == 1 }.toIntArray()
        assertTrue(arrayFiltered contentEquals intArrayOf(1, 3, 5))

    }
}
