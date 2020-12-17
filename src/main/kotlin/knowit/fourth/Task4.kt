package knowit.fourth

import java.io.File

fun main() {

    val sumOrders = mutableMapOf<String, Int>()

    File("src/main/kotlin/knowit/fourth/leveringsliste.txt")
        .forEachLine { line ->
            val orderMap = line.split(",").associate {
                val (ingredient, value) = it.split(':')
                ingredient.trim() to value.trim().toInt()
            }

            orderMap.forEach { (ingredient, value) ->
                sumOrders.merge(ingredient, value, Integer::sum)
            }
        }

    println("Sukker = " + sumOrders["sukker"]?.div(2))
    println("Mel = " + sumOrders["mel"]?.div(3))
    println("Melk = " + sumOrders["melk"]?.div(3))
    println("Egg = " + sumOrders["egg"]?.div(1))
}