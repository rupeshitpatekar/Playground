package inheritance

interface Remote {
    fun up()
    fun down()

    fun doubleUp(){
        up()
        up()
    }
}

class TV{
    var volume = 0
}

class TVRemote(val tv: TV): Remote{
    override fun up() {
        tv.volume++
    }

    override fun down() {
        tv.volume--
    }

}

fun main(){
    val tv = TV()
    val remote = TVRemote(tv)
    println("Volume: ${tv.volume}")
    remote.up()
    println("After up: ${tv.volume}")
    remote.doubleUp()
    println("Volume after double up: ${tv.volume}")
}