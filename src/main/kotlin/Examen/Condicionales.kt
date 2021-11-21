package Examen

import kotlin.random.Random

fun main() {
    ifUsage()
    whenUsageWithParameters()
    whenUsageWithoutParameters()
}

fun ifUsage(){
    val numero = Random.nextInt(0,12)
    // If - Else Clasico
    if (numero == 0) {
        println("$numero es igual a 0 ")
    } else {
        println("$numero es diferente a 0 ")
    }
    // If - Else Rango
    if (numero in 0..9){
        println("$numero es un numero comprendido entre 0 y 9")
    } else {
        println("$numero es mayor que 9")
    }
}

fun whenUsageWithParameters(){
    val numero = Random.nextInt(-10,103)

    when (numero) {
        0 -> println("$numero es igual a 0 ")
        in 1..99 -> println("$numero es un numero comprendido entre 0 y 99")
        100, 101 -> println("$numero es 100 o 101")
        else -> println("$numero es menor de 0 o mayor de 101")
    }
}

fun whenUsageWithoutParameters(){
    val condicion1 = Random.nextBoolean()
    val condicion2 = Random.nextBoolean()

    when  {
        condicion1 && condicion2 -> println("Ambas son true")
        (!condicion1 && condicion2) || (condicion1 && !condicion2) -> println("Una es true")
        !condicion1 && !condicion2 -> println("Ambas son false")
    }
}