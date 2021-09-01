import org.junit.Test
import kotlin.test.assertEquals

class TripleExampleTest {

    @Test
    fun `should get full name in a seperate variable`(){
        val (first, middle, last ) = getFullName()
        assertEquals("Rupeshit", first)
        assertEquals("Kalpesh", middle)
        assertEquals("Patekar", last)
    }

    @Test
    fun `should skip first & middle name`(){
        val (_,_,last) = getFullName()
        assertEquals("Patekar", last)
    }

    @Test
    fun `should stop at the middle name`(){
        val (_, middle) = getFullName()
        assertEquals("Kalpesh", middle)
    }
}