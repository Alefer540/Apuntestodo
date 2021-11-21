package Examen.Dados2

import kotlin.random.Random

fun main() {
    //Partiendo del ejercicio anterior.
    //
    //Crea 100 dados con número máximo y número mínimo aleatorio en cada uno de ellos. Tira 200 veces cada dado en tirada múltiple.
    //Haz una función que devuelva la media de tiradas únicas del dado.
    //Haz una función que devuelva la media de tiradas dobles del dado.
    //Cuando ya han tirado todos los dados, imprime la media de todos los dados y la media de ambas tiradas (múltiple y única).
    //Atención! Si se cambia el rango de valores la media debe reiniciarse.

    val listaDados = List(100) { Dado() }

    listaDados.forEach { dado ->
        dado.darValores(Random.nextInt(0, 100), Random.nextInt(0, 100))
    }

    listaDados.forEachIndexed { index, dado ->
        for (i in 0 until 100 ) {
            dado.tiradaDoble()
            dado.tiradaUnica()
        }

        println("Para el dado$index:")
        dado.mostrarEstadisticas()
    }


}