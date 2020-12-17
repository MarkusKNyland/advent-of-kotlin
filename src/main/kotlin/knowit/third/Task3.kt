package knowit.third

import java.io.File

fun main() {
    val words: ArrayList<String> = ArrayList()
    words.addAll(ArrayList(File("src/main/kotlin/knowit/third/ordliste.txt").readLines()))
    words.addAll(words.map {
        it.reversed()
    })
    val matrix: List<CharArray> = File("src/main/kotlin/knowit/third/bokstav-matrise.txt").readLines()
        .map { it.toCharArray() }

    val start = System.currentTimeMillis()

    words.forEachIndexed { index, word ->
        val wordLength = word.length
        var lettersMatched = 0
        var x = 0
        var y = 0
        var linesSearched = 0

        while (linesSearched < matrix.size) {

            while (x < matrix[y].size) {
                if (lettersMatched == wordLength) {
                    println("${printWord(words, index)} found horizontally in line: ${linesSearched + 1} starting at spot ${x + 1}")
                    break
                }
                val xPositionToCheck = x + lettersMatched
                if (xPositionToCheck < matrix[y + linesSearched].size && matrix[y + linesSearched][xPositionToCheck] == word[lettersMatched]) {
                    lettersMatched++
                } else {
                    lettersMatched = 0
                    x++
                }
            }
            lettersMatched = 0
            x = 0

            while (y < matrix.size) {
                if (lettersMatched == wordLength) {
                    println("${printWord(words, index)} found vertically in column: ${linesSearched + 1} starting at spot ${y + 1}")
                    break
                }
                val yPositionToCheck = y + lettersMatched
                if (yPositionToCheck < matrix.size && matrix[yPositionToCheck][x + linesSearched] == word[lettersMatched]) {
                    lettersMatched++
                } else {
                    lettersMatched=0
                    y++
                }
            }
            lettersMatched = 0
            y = 0

            var yPositionToCheck = 0
            var xPositionToCheck = 0
            while (yPositionToCheck >= 0 && yPositionToCheck < matrix.size &&
                xPositionToCheck >= 0 && xPositionToCheck < matrix[yPositionToCheck].size) {
                val char = matrix[yPositionToCheck][xPositionToCheck]
                if (char == word[lettersMatched]) {
                    lettersMatched++
                }
                else {
                    lettersMatched = 0
                    x++
                }
                if (lettersMatched == wordLength) {
                    println("${printWord(words, index)} found diagonally")
                    break
                }
                yPositionToCheck = lettersMatched + linesSearched
                xPositionToCheck = x - lettersMatched
            }
            lettersMatched = 0

            yPositionToCheck = 0
            xPositionToCheck = matrix[linesSearched].size -1
            x = xPositionToCheck
            while (yPositionToCheck >= 0 && yPositionToCheck < matrix.size &&
                xPositionToCheck >= 0 && xPositionToCheck < matrix[yPositionToCheck].size) {
                val char = matrix[yPositionToCheck][xPositionToCheck]
                if (char == word[lettersMatched]) {
                    lettersMatched++
                }
                else {
                    lettersMatched = 0
                    x--
                }
                if (lettersMatched == wordLength) {
                    println("${printWord(words, index)} found diagonally")
                    break
                }
                yPositionToCheck = lettersMatched + linesSearched
                xPositionToCheck = x + lettersMatched
            }
            lettersMatched = 0
            x = 0

            linesSearched++
        }
    }
    println(System.currentTimeMillis() - start)
}

fun printWord(words : List<String>, index : Int) : String {
    return if (index < words.size / 2) {
        words[index]
    }
    else words[index].reversed()
}