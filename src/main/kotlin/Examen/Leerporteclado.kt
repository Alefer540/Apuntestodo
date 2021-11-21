package Examen

import java.util.*

//CARACTER
fun readCharFromKeyboardd(): Char {
    var result: Char?
    val keyboardReader = Scanner(System.`in`)
    do {
        val selectedOption = keyboardReader.nextLine()
        result = if (selectedOption.length == 1) selectedOption[0] else null
    } while (result == null)
    return result
}

//INT
fun readIntFromKeyboardD(): Int {
    var result : Int?
    do {
        val selectedOption = readLine()
        result = try {
            selectedOption?.toInt()
        } catch (e: NumberFormatException) {
            println("Lo que has introducido no es un número.")
            null
        }
    } while (result == null)
    return result
}
//String
//Mi ahoracado de clase creo que lo tenia