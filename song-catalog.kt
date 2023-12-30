// class definition practice

class Song(val title: String, val artist: String, val yearPublished: Int, val playCount: Int) {
    val popular: Boolean = playCount >= 1000
    
    fun printDescription(): Unit {
        println("$title, performed by $artist, was released in $yearPublished")
    }
}

fun main() {
    val song = Song("Fake It", "The Jeebies", 1974, 72)
    
    song.printDescription()
    println("The song was${if(!song.popular) " not" else ""} popular")
}