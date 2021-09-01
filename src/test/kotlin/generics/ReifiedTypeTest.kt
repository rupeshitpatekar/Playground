package generics

import org.junit.Test
import kotlin.test.assertEquals

class ReifiedTypeTest {

    private val books = listOf(Fiction("Moby Dick"), NonFiction("Learn to Code"), Fiction("LOTR"))

    @Test
    fun `should return type of class without reified type`(){
        assertEquals("Learn to Code", findFirstWithoutReified(books, NonFiction::class.java).name)
    }

    @Test
    fun `should return type of class with reified type`(){
        assertEquals("Learn to Code", findFirstWithReified<NonFiction>(books).name)
    }
}