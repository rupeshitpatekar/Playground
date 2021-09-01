import org.junit.Test
import kotlin.test.assertEquals

internal class WhenExampleTest{
    @Test
    fun `should return action on the basis of days`(){
        assertEquals("Relax", whatToDo("Sunday"))
        assertEquals("Party", whatToDo("Friday"))
        assertEquals("Work Hard", whatToDo("Monday"))
        assertEquals("Work Hard", whatToDo(3))
        assertEquals("What?", whatToDo("Moonday"))
        assertEquals("No clue", whatToDo(10))
    }
}