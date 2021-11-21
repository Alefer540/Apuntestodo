package Examen.KDRatioConstructores

class Jugador(var nombre : String = "",
              var partidasJugadas : Int = 0,
              var tiempoJugado : Int = 0,
              var kills : Int = 0,
              var deaths : Int = 0) {

    private fun getKD(): Double {
        return kills.toDouble() / deaths.toDouble()
    }

    fun getDetalles(): String {
        return "El jugador $nombre lleva $partidasJugadas partidas jugadas en $tiempoJugado horas jugadas, con un resultado de $kills bajas por $deaths muertes. Por tanto el K/D es de ${getKD()}"
    }
}