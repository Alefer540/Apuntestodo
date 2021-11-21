package Examen

import java.util.*

fun main(){
    val palabraBuscada = "NEREA"
    val listaEleccionesUsuario = mutableListOf<Char>()
    var intentos = 0
    do {
        println("Elije una letra")
        println("Ya has probado con las siguientes letras $listaEleccionesUsuario")
        val letra = readCharFromKeyboard().toUpperCase()
        if (listaEleccionesUsuario.contains(letra)){
            println("la letra $letra ya ha sido escogida, prueba con otra.")
        } else {
            intentos++
            listaEleccionesUsuario.add(letra)
        }
        val palabraEnOculto = getPalabraEnOculto(palabraBuscada, listaEleccionesUsuario)
        println(palabraEnOculto)
    }  while (palabraEnOculto.contains("_"))
    println("Enhorabuena! has acertado. La palabra era $palabraBuscada. Has necesitado $intentos intentos")
}

fun getPalabraEnOculto(palabraBuscada: String, listChar: List<Char>) : String {
    var palabraEnOculto = ""
    palabraBuscada.toUpperCase().toCharArray().forEach { char ->
        if (listChar.contains(char)){
            palabraEnOculto += char
        } else {
            palabraEnOculto += "_"
        }
    }
    return palabraEnOculto
}



fun readCharFromKeyboard(): Char {
    var result: Char?
    val keyboardReader = Scanner(System.`in`)
    do {
        val selectedOption = keyboardReader.nextLine()
        result = if (selectedOption.length == 1) selectedOption[0] else null
    } while (result == null)
    return result
}