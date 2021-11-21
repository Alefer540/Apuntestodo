package Examen.Dados3

import kotlin.random.Random

class Dado(var numMin: Int = 1, var numMax: Int = 6) {

    init {
        darValores(numMin, numMax)
    }

    fun darValores(valMin: Int, valMax: Int) {
        if (valMin <= valMax) {
            numMax = valMax
            numMin = valMin
        } else {
            println("Se han cambiado los valores min y maximo")
            numMax = valMin
            numMin = valMax
        }
    }

    fun tiradaUnica (): Int {
        return Random.nextInt(numMin, numMax + 1)
    }

}