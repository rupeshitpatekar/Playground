package generics

open class Fruit
class Banana: Fruit()
class Orange: Fruit()

fun receiveArrayFruits(fruits: Array<Fruit>){
    println("Number of fruits ${fruits.size}")
}

fun mutableBananas(){
    val bananas: Array<Banana> = arrayOf()
    //receiveArrayFruits(bananas) ERROR
}

fun receiveListFruits(fruits: List<Fruit>){
    println("Number of fruits ${fruits.size}")
}

fun immutableBananas(){
    val bananas = listOf<Banana>()
    receiveListFruits(bananas) //NO ERROR
}
/**
 * That makes sense, but you may be curious how Kotlin knows how to tell the difference.
 * The answer to that lies in how the two types are defined: class Array<T> vs. interface List<out T>.
 * That out is the secret sauce.
 *
 * This is called as declaration-site variance
 */

