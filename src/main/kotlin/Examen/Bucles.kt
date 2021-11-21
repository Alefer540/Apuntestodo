package Examen

fun main(){

    //Repeat

    var numeroPisos = 10
    var numeroVentanas = 4
    repeat(numeroVentanas*3+2){
        print("_")
    }
    println()
    repeat(numeroPisos) {
        print("|")
        repeat(numeroVentanas){
            print("_▋_")
        }
        println("|")
    }



     //Adivina numeros


    // Escribe un programa que permita jugar a adivinar un numero.
    //
    // El resultado por pantalla deber ser el siguiente
    // Encuentra un numero entre 0..9
    // Escribe tu numero
    // 1 <- Valor introducido por el usuario
    // El numero buscado es mas grande
    // Escribe tu numero
    // 9 <- Valor introducido por el usuario
    // El numero buscado es mas peque
    // Escribe tu numero
    // 5 <- Valor introducido por el usuario
    // El numero buscado es mas peque
    // Escribe tu numero
    // 3 <- Valor introducido por el usuario
    // Enhorabuena! El numero era 3

    val rango = 1..9

    val numeroBuscado = getRandomNumber(1..9)
    println("Encuentra un numero entre $rango")
    do {
        println("Escribe tu numero")
        val opcionUsuario = readIntFromKeyboard()
        val encontrado = when {
            numeroBuscado > opcionUsuario -> {
                println("El numero buscado es mas grande")
                false
            }
            numeroBuscado < opcionUsuario -> {
                println("El numero buscado es mas peque")
                false
            }
            else -> {
                println("Enhorabuena! El numero era $numeroBuscado")
                true
            }
        }
    } while (!encontrado)
}


//Leer int por teclado
fun readIntFromKeyboard(): Int {
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

fun getRandomNumber(rango: IntRange): Int {
    return rango.random()
}