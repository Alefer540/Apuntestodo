package Examen

fun main(){
    println("---EjemploExtensiones---")

    val string1 = "0123456789"
    val string2 = "Hola 1"
    val string3 = "Hola 123"

    println("String1 tiene ${string1.countNumber()} números, el String 2 tiene ${string2.countNumber()} número y el String 3 tiene ${string3.countNumber()} números.")

}


fun String.countNumber() : Int{
    var count = 0
    forEach {
        if (it.isDigit()) count++
    }
    return count
}