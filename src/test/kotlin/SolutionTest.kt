import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class SolutionTest{
    @Test fun `should filter numbers`(){
        val numbers = listOf(1,2,3,4,5)
        val solution = Solution()
        assertEquals(listOf(2,4), solution.filterEvenNumbers(numbers))
    }
}