package knowit.sixth

import java.io.File

fun main() {

    var candyPieces = 0
    val candyPackages = ArrayList<String>()

    File("src/main/kotlin/knowit/sixth/godteri.txt").forEachLine { line ->
        line.split(",").forEach {
            candyPackages.add(it)
            candyPieces += it.toInt()
        }
    }

    while (true) {
        if (candyPieces % 127 == 0) {
            println(candyPieces / 127)
            break
        }
        candyPieces -= candyPackages.removeLast().toInt()
    }
}
