package Examen.Dados3

var listaOrdenada = listOf<Jugador>()
fun main() {
    //Partiendo del ejercicio carlosbellmont/EjercicioDados (github.com)
    //
    //Modifícalo para que:
    //
    //El dado pueda inicializarse con un valor mínimo y otro máximo.
    //Por defecto se inicie con valores del 1 al 6.
    //Inicializa 3 dados, uno con el valor por defecto, otro con un rango del 1 al 3 y otro con un rango del 4 al 6.
    //
    //Crea 100 jugadores que tirarán cada dado 100 veces cada uno de los dados.
    //
    //Calcula la puntuación total de cada jugador, siendo el resultado la suma de todas las tiradas de los dados.
    //
    //Debes tener un función llamada mostrarResultados que devuelve un string que contiene la lista ordenada de mayor puntuación a menor puntuación de los jugadores.
    //
    //fun mostrarResultado(): String {
    //
    //}
    //
    //Ejemplo:
    //
    //Jugador 57 ha sacado 1000 puntos
    //
    //Jugador 50 ha sacado 999 puntos
    //
    //Jugador 59 ha sacado 990 puntos
    //
    //etc...

    val dado1 = Dado()
    val dado2 = Dado(1,3)
    val dado3 = Dado(4,6)


    val listaJugadores = List(100){
        Jugador(it.toString(), dado1,dado2,dado3)
    }

    listaOrdenada = listaJugadores.sortedByDescending { it.sumaTotal }


    println(mostrarResultado())
}

fun mostrarResultado():String {
    var output = ""
    listaOrdenada.forEach { output += it.toString() + "\n" }
    return output
}

class Jugador(val nombre: String, val dado1: Dado, val dado2: Dado, val dado3: Dado) {

    var sumaTotal = 0

    init {
        repeat(100){
            sumaTotal += dado1.tiradaUnica()
            sumaTotal += dado2.tiradaUnica()
            sumaTotal += dado3.tiradaUnica()
        }
    }

    override fun toString(): String {
        return "Jugador $nombre ha sacado $sumaTotal puntos"
    }
}