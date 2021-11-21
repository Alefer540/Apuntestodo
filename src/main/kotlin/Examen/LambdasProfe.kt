package Examen

import kotlin.random.Random

fun main() {
    // Así creo una lambda y la ejecuto.
    { println("Hola") }()
    var decirHola = { println("Hello") }
    decirHola()

    var decirAlgo = { algo : String, otraCosa : Int -> repeat(otraCosa) { println("Digo $algo") } }
    decirAlgo("booom!", 2)


    var sumar = {num1 : Int, num2 : Int ->
        if (Random.nextBoolean())
            num1+ num2
        else
            ":)"
    }

    var a = sumar(2,3)
    when (a) {
        is Int -> println("Era un número")
        is String -> println("Era un string")
    }
    println(a)

    val hazResta: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 - num2 }


    var lambda = { letra : Char -> if (!letra.isDigit()) print(letra) }
    "hola1".forEach(lambda)
    "pez12342".forEach(lambda)
    "Agua6134123412342".forEach(lambda)
}
