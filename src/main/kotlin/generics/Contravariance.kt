package generics

class Contravariance {
    fun copyFromTo(from: Array<out Fruit>, to: Array<in Fruit>) {
        for (i in 0 until from.size) {
            to[i] = from[i]
        }
    }

    fun callCopyFromTo(){
        val thingsBasket = Array<Any>(3) { _ -> Fruit() }
        val bananaBasket = Array<Banana>(3) { _ -> Banana() }
        copyFromTo(bananaBasket, thingsBasket)
    }
}
