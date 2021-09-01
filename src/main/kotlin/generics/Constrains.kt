package generics

class Constrains {
    /**
     * Without any constraints
     */
//    fun <T> useAndClose(input: T){
//        input.close() ERROR- unresolved reference: close
//    }

    /**
     * For single constraints
     */
    fun <T:AutoCloseable> useAndClose(input: T): T {
        input.close()
        return input
    }


    fun <T> whereConstraint(input: T): T
            where T : Appendable, T : AutoCloseable {
        input.append(" there")
        input.close()
        return input
    }

}