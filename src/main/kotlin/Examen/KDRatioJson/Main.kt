package Examen.KDRatioJson

fun main() {

    val jugador1 = Jugador("Alfredo", 15, 21, 24, 20)

    println(jugador1.getDetalles())
    jugador1.guardarJugador()

    val jugador2 = cargarJugador("Godofredo")//Aqui puedes poner nombres diferentes y te crea el archivo
    jugador2.kills++
    jugador2.kills++
    jugador2.tiempoJugado++
    println(jugador2.getDetalles())
    jugador2.guardarJugador()
}