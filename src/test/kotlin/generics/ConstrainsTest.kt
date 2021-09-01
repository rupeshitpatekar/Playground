package generics

import org.junit.Test

internal class ConstrainsTest {
    private val constrains = Constrains()

    @Test
    fun `should use single constraint`() {
        val writer = java.io.StringWriter()
        writer.append("hello")
        kotlin.test.assertEquals("hello",constrains.useAndClose(writer).toString())
    }

    @Test
    fun `should use multiple constraint`() {
        val writer = java.io.StringWriter()
        writer.append("hello")
        kotlin.test.assertEquals("hello there",constrains.whereConstraint(writer).toString())
    }
}