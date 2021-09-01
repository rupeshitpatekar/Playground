import org.junit.Test
import kotlin.test.assertEquals

class RangeTest {
    @Test fun `should check range from one to five`(){
        assertEquals(true, oneToFive.contains(3))
        assertEquals(false, oneToFive.contains(8))
    }

    @Test fun `should check String range`(){
        assertEquals(true, seekHelp.contains("hello"))
        assertEquals(false, seekHelp.contains("helq"))
    }
}