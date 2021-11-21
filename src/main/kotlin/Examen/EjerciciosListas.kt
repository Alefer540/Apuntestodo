package Examen

import kotlin.random.Random

fun main(){
    //Crea una lista “listaRandom” de entre 90 y 110 números aleatorios comprendidos entre el 0 y el 9.
    //Crea una lista vacía “listaResultado” en cuya posición…
    //Posición 0 se debe contar cuantos 0 hay en la listaRandom.
    //Posición 1 se debe contar cuantos 1 hay en la listaRandom.
    //etc. con todos los números.
    val listaRandom = crearListaAleatorio()
    val listaResultado = contrarLista(listaRandom)
    println("ListaRandom = $listaRandom")
    println("ListaResultado = $listaResultado")

//Crea una lista de varios elementos
//Utilizando únicamente lo visto hasta ahora y este código:
//val lista = listOf("Hola,", 2, 3, "¿", 0.1, "Qué", 1, "tal", 0.9, "?")
//
//
//Realiza un programa que:
//Sume todos los números de la lista en una misma variable (Integers y Doubles).
//Concatena todos los String en un único String. Añadiendo un espacio por cada uno.

    val lista = crearLista()
    var contenidoString = ""
    var sumatorioDouble = 0.0
    lista.forEach {
        when (it) {
            is String -> contenidoString += "$it "
            is Double -> sumatorioDouble += it
            is Int -> sumatorioDouble += it
        }
    }
    println("La lista contiene $lista")
    println("El contenido contiene $contenidoString")
    println("El sumatorio contiene $sumatorioDouble")

}

fun crearLista(): List<Any> {
    return listOf("Hola,", 2, 3, "¿", 0.1, "Qué", 1, "tal", 0.9, "?")
}


fun crearListaAleatorio() : List<Int>{
    return MutableList(Random.nextInt(90,110)){ Random.nextInt(0,10) }
}

fun contrarLista(listaRandom: List<Int>) : List<Int>{
    val output = mutableListOf<Int>()
    for (numero in 0..9) {
        var ocurrencias = 0
        for (numRandom in listaRandom) {
            if (numRandom == numero) {
                ocurrencias++
            }
        }
        output.add(numero, ocurrencias)
    }
    return output
}