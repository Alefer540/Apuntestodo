package Examen.Constructores

import kotlin.random.Random

fun main() {

    val listaDados = List(100) { DadoConstructorPredefinido() }

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