package knowit.fifth

import java.io.File

fun main() {

    // Example 1 = 4 square meters
    //val directions = "HHOOVVNN".toCharArray()

    // Example 2 = 14 square meters
    //val directions = "HHHHHHOOOOVVNNNVVOVVNN".toCharArray()

    val directions = File("src/main/kotlin/knowit/fifth/museliste.txt").readText().toCharArray()

    var x = 0
    var y = 0
    val coordinates: ArrayList<Pair<Int, Int>> = arrayListOf(Pair(0, 0))

    var lastDirection: Char = directions[0]
    directions.forEach {
        when (it) {
            'H' -> {
                x++
                if (it != lastDirection) {
                    coordinates.add(Pair(y, x - 1))
                }
                lastDirection=it
            }
            'V' -> {
                x--
                if (it != lastDirection) {
                    coordinates.add(Pair(y, x + 1))
                }
                lastDirection=it
            }
            'O' -> {
                y++
                if (it != lastDirection) {
                    coordinates.add(Pair(y - 1, x))
                }
                lastDirection=it
            }
            'N' -> {
                y--
                if (it != lastDirection) {
                    coordinates.add(Pair(y + 1, x))
                }
                lastDirection=it
            }
        }
    }

    println(coordinates)

    var m = 0
    var n = 0
    for (i in coordinates.indices) {
        if (i == coordinates.size - 1) break
        m += coordinates[i].first * coordinates[i + 1].second
        n += coordinates[i].second * coordinates[i + 1].first
    }
    m += coordinates[coordinates.size - 1].first * coordinates[0].second
    n += coordinates[coordinates.size - 1].second * coordinates[0].first

    val area = 0.5 * (n - m)
    println(area)
}