package generics

abstract class Book(name: String)
data class Fiction(val name: String): Book(name)
data class NonFiction(val name: String): Book(name)

fun <T> findFirstWithoutReified(books: List<Book>, ofClass: Class<T>): T {
    val selected = books.filter { book -> ofClass.isInstance(book) }
    if(selected.isEmpty()) throw RuntimeException("Not Found")

    return ofClass.cast(selected[0])
}

inline fun <reified T> findFirstWithReified(books: List<Book>): T {
    val selected = books.filter { book -> book is T }
    if(selected.isEmpty()) throw RuntimeException("Not Found")

    return selected[0] as T
}