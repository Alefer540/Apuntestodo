package Examen.KDRatioFicheros

import java.io.File

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

    fun guardarJugador(){
        val archivo = File("Jugadores/$nombre.txt")//Aqui metes la ruta
        archivo.writeText("${partidasJugadas}\n")
        archivo.appendText("${tiempoJugado}\n")
        archivo.appendText("${kills}\n")
        archivo.appendText("${deaths}\n")
    }

    fun cargarJugador(){
        try {
            val archivo = File("Jugadores/$nombre.txt")//Aqui metes la ruta
            val lineas = archivo.readLines()
            partidasJugadas = lineas[0].toInt()
            tiempoJugado = lineas[1].toInt()
            kills = lineas[2].toInt()
            deaths = lineas[3].toInt()
        } catch (exception : Exception) {
            println("Error la leer los datos.")
        }
    }
}