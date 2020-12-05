package knowit.`1`

import java.io.File

/** Task nr 1 - Missingno
 * In the file 'numbers.txt' are all numbers from 1 to 100_000 apart from one. Find which one
 * They are in random order separated by ','
**/
fun main() {

    var checksum = 0
    for (i in 1..100_000) {
        checksum += i
    }

    var sum = 0
    File("src/main/kotlin/knowit/1/numbers.txt")
        .forEachLine { line ->
            line.split(",")
                .forEach { number ->
                    sum += Integer.parseInt(number)
                }
        }

    println(checksum - sum)
}