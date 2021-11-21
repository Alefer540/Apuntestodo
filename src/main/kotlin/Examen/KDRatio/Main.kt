package Examen.KDRatio

fun main() {
    //Vamos a mostrar las estadísticas de un videojuego.
    //Tenemos a los jugadores, los cuales tienen unas estadísticas de juego. Además del nombre, los jugadores tienen un número de partidas jugadas, número de horas jugadas, número de kills, número de dead y K/D (ratio kill - dead).
    //Crea una clase jugadores con los datos requeridos.
    //Crea lo necesario para poder crear por teclado un jugador por teclado.
    //Muestra las estadísticas por pantalla de todos los jugadores.

    val jugador1 = Jugador()
    jugador1.nombre = "Alfredo"
    jugador1.deaths = 15
    jugador1.kills = 21
    jugador1.tiempoJugado = 24
    jugador1.partidasJugadas = 20

    println(jugador1.getDetalles())
}