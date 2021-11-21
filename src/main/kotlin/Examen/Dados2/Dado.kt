package Examen.Dados2

import kotlin.random.Random

class Dado {
    private var numMin = 0
    private var numMax = 10
    private var resultadosTiradaDoble = mutableListOf<Int>()
    private var resultadosTiradaUnica = mutableListOf<Int>()

    fun darValores(valMin: Int, valMax: Int) {
        if (valMin == valMax) {
            numMax = valMax + 1
            numMin = valMin
        } else if (valMin < valMax) {
            numMax = valMax
            numMin = valMin
        } else {
            println("Se han cambiado los valores min y maximo")
            numMax = valMin
            numMin = valMax
        }
        resultadosTiradaDoble = mutableListOf()
        resultadosTiradaUnica = mutableListOf()

    }

    fun tiradaUnica (): Int {
        val tirada = Random.nextInt(numMin, numMax)
        resultadosTiradaUnica.add(tirada)

        return Random.nextInt(numMin, numMax)
    }

    fun tiradaDoble (): Int {
        val num1 = Random.nextInt(numMin, numMax)
        println("num1 = $num1")
        val num2 = Random.nextInt(numMin, numMax)
        println("num2 = $num2")
        val tirada = if (num1 == num2) num1 * num2 else num1 + num2
        resultadosTiradaDoble.add(tirada)
        return tirada
    }

    fun mediaDobles() : Double {
        var total = 0
        resultadosTiradaDoble.forEach {
            total += it
        }
        return total.toDouble() / resultadosTiradaDoble.size
    }

    fun mediaUnicas() : Double {
        var total = 0
        resultadosTiradaUnica.forEach {
            total += it
        }
        return total.toDouble() / resultadosTiradaUnica.size
    }

    fun mostrarEstadisticas(){
        print("Realiza tiradas desde $numMin hasta $numMax,")
        print(" lleva ${resultadosTiradaUnica.size} lanzamientos dobles con una media de ${mediaUnicas()}")
        print(" lleva ${resultadosTiradaDoble.size} lanzamientos dobles con una media de ${mediaDobles()}")
    }
}