package archivos

fun main() {

    val jugador1 = Jugador("Alfredo", 15, 21, 24, 20)

    println(jugador1.getDetalles())
    jugador1.guardarJugador()

    val jugador2 = Jugador("Godofredo", 1, 2, 3, 4)
    jugador2.cargarJugador()
    jugador2.kills++
    jugador2.kills++
    jugador2.tiempoJugado++
    println(jugador2.getDetalles())
    jugador2.guardarJugador()
}