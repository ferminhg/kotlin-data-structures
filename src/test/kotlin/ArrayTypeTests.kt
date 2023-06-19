import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


data class Person(val name: String, val height: Double)

class ArrayTypeTests {

    private val zeroToTen = 0..10
    private val zeroToFive = 0..5
    private val emptyArray = intArrayOf()
    private val emptyIntArray: Array<Int> = emptyArray<Int>()
    private val arrayChar = 'a'..'z'
    private val isEven = { it: Int -> it % 2 == 0}


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

    @Test
    fun `test all function`() {
        // Return true if all elements match the predicate
        assertTrue(zeroToFive.all { it < 10 })
        assertTrue(emptyArray.all { it < 10 })

        val isLessThanTen: (Int) -> Boolean = { it: Int -> it < 10 }
        assertTrue(zeroToFive.all(isLessThanTen))

        assertTrue(arrayChar.all { it.isLowerCase() }, "Not all characters are lowercase")

        assertFalse(zeroToTen.all(isEven))
        assertFalse(zeroToTen.all { isEven(it) })
        assertFalse(zeroToTen.all { false })

        assertTrue(emptyArray.all(isEven))
        assertTrue(emptyArray.all { false })
    }

    @Test
    fun `test any function`() {
        assertTrue(zeroToFive.any { it < 1 })
        assertFalse(zeroToFive.any { it < 0 })
        assertFalse(emptyArray.any())

        assertTrue(zeroToFive.any(isEven))
    }

    @Test
    fun  `test map function `() {
        val expected = intArrayOf(0, 2, 4, 6, 8, 10)
        assertTrue( zeroToFive.map { it * 2}.toIntArray()
                    contentEquals
                    expected)

        assertTrue( zeroToTen.filter(isEven).map { it * 2}.toIntArray()
                    contentEquals
                    intArrayOf(0, 4, 8, 12, 16, 20))

        // using map to generate one array of different types
        assertTrue( zeroToTen.map { true }.toBooleanArray()
                    contentEquals
                    BooleanArray(11) { true })

        // Tuples
        val peopleToAge = mapOf("Alice" to 20, "Bob" to 21)
        assertTrue( peopleToAge.map { it.key }.toTypedArray()
                    contentEquals
                    arrayOf("Alice", "Bob"))
        assertTrue( peopleToAge.map { (name, age) -> "$name is $age years old" }.toTypedArray()
                    contentEquals
                    arrayOf("Alice is 20 years old", "Bob is 21 years old"))


        val mountainsToHeight = mapOf("Uriellu" to 2194, "Midi d'Ossau" to 2884)
        mountainsToHeight.maxBy { it.value }.let { (mountain, height) ->
            assertEquals("Midi d'Ossau", mountain)
            assertEquals(2884, height)
        }
    }

    @Test
    fun `test flatmap function`() {
        val listCharNumbers = listOf("3123", "455")
        val newShit = listCharNumbers.flatMap { it.toList() }
            .map { it.toString().toInt()+100 }
            .flatMap { it -> it.toString().toList().map { it.toString().toInt() }}
            .filter { it > 0 }

        assertTrue(
            newShit.toIntArray()
                contentEquals
                intArrayOf(1, 3, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 5)
        )

        //obtener una lista que contenga todas las letras de esas palabras de forma individual.
        val listWords = listOf("muka", "mora", "sombrita", "beka", "isi", "maya")
        assertEquals(listWords.flatMap { it.toList() }.size, listWords.sumOf { it.length })


        // lista que contenga los cuadrados de todos los números pares presentes en las sublistas
        val numberMatrix = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9)
        )
        
        val result = numberMatrix.flatMap { it.filter(isEven).map{ x -> x * x }}
        assertTrue(result.toIntArray() contentEquals intArrayOf(4, 16, 36, 64))

        val flattenMatrix = numberMatrix.flatten().filterNot(isEven).map { it * it }
        assertTrue(flattenMatrix.toIntArray() contentEquals intArrayOf(1, 9, 25, 49, 81))
    }

    @Test
    fun `test maxOf and minOf functions`() {
        assertEquals(10, zeroToTen.maxOf { it })

        val peopleToAge = mapOf("Alice" to 20, "Bob" to 21)
        assertEquals(21, peopleToAge.maxOf { it.value })
        assertEquals("Bob", peopleToAge.maxOf { it.key })


        assertNull(emptyArray.maxOfOrNull { it })
    }

    @Test
    fun  `test maxOfWith and minOf function`() {
        val people = listOf(
            Person("Juan", 170.0),
            Person("María", 165.5),
            Person("Pedro", 180.3),
            Person("Laura", 175.2)
        )

        val personaAlta = people.maxOfWith(compareBy { it.height}) { it }
        assertEquals(personaAlta, people[2])


        val comparator = Comparator<Int> { _, _ -> 0 }

        assertThrows(NoSuchElementException::class.java) {
            emptyIntArray.maxOfWith(comparator) { it }
        }

    }

    @Test
    fun  `test plus and minus funtions`() {
        assertEquals( zeroToFive.count() + 1 , zeroToFive.plus(6).size)
        assertEquals( zeroToFive.count()  - 1, zeroToFive.minus(1).size)
    }

    @Test
    fun `test onEach function`() {
        val list = mutableListOf<Int>()
        val result = zeroToFive.onEach { list.add(it) }
        assertTrue(result == zeroToFive)
    }
}
