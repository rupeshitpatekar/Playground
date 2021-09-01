package generics

fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>){
    for(i in 0 until from.size) {
        to[i] = from[i]

//        from[i] = Fruit() //ERROR
//        from.set(i, to[i]) //ERROR
    }
}

/**
 * Example of Use-site variance
 */
fun callCopyFromTo(){
    val fruitsBasket = Array<Fruit>(3) { _ -> Fruit() }
    val bananaBasket = Array<Banana>(3) { _ -> Banana() }
    copyFromTo(bananaBasket, fruitsBasket)
}