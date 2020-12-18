package knowit.second

/** Task nr 2 - Julenissens sinneproblem
 *
 * Julenissen skal levere pakker til alle snille barn. For å holde styr på pakkene merker alvene hver pakke
 * med et unikt tall. Den første pakken får tallet 0 (alvene nullindekserer selvsagt), den andre pakken 1 osv.
 * Julenissen drar alltid opp pakkene i numerisk rekkefølge fra sekken.
 *
 * Julenissen hater av en eller annen grunn sifferet 7, og reagerer sterkt når han ser en pakke med dette sifferet.
 * Hans reaksjon er at han kaster pakken i søpla, og i ukontrollert sinne også kaster de P neste pakkene,
 * hvor P er nærmeste primtall som er mindre eller lik tallet på pakken.
 *
 * Julenissen skal levere pakker til alle de snille barna i Norge. Terskelen er ganske lav for hva Julenissen
 * anser som et snilt barn, vi er alle snille barn i Julenissens øyne. Dvs. hele norges befolkning på 5433000,
 * skal få en pakke levert. Hvor mange av disse pakkene vil faktisk bli levert?
 **/
fun main() {
    var i = 0
    val delivered = ArrayList<Int>()

    while (i < 5_433_000) {
        if (getLastDigit(i) == 7) {
            i += getClosestPrime(i)
        } else {
            delivered.add(i)
        }
        i++
    }
    println(delivered.size)
}

private fun getClosestPrime(number: Int): Int {
    for (i in number downTo 2) {
        if (isPrimeNumber(i)) return i
    }

    // shouldn't happen
    return 0
}

private fun getLastDigit(number: Int): Int {
    return number % 10
}

private fun isPrimeNumber(number: Int): Boolean {
    for (i in 2..number / 2) {
        if (number % i == 0) return false
    }
    return true
}

