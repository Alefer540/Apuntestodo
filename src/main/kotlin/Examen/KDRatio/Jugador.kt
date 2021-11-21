package Examen.KDRatio

class Jugador {

    var nombre = ""
    var partidasJugadas = 0
    var tiempoJugado = 0
    var kills = 0
    var deaths = 0

    fun getKD(): Double {
        return kills.toDouble() / deaths.toDouble()
    }

    fun getDetalles(): String {
        return "El jugador $nombre lleva $partidasJugadas partidas jugadas en $tiempoJugado horas jugadas, con un resultado de $kills bajas por $deaths muertes. Por tanto el K/D es de ${getKD()}"
    }
}