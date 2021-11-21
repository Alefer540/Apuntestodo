package Examen

import kotlin.random.Random

var a = dameAlgoAleatorio()

fun main() {

    a.let {
        if (it is Int){
            println("Soy un integer que vale $it y ahora valgo ${it+1}")
        }
        if (it is String) {
            println("Soy un String que mido ${it.length}")
        }
    }
}


fun dameAlgoAleatorio(): Any {
    return if (Random.nextBoolean()) 5 else "Hola"
}