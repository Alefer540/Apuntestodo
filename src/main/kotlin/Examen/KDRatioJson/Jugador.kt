package Examen.KDRatioJson

import com.google.gson.Gson
import java.io.File

data class Jugador(var nombre : String = "",
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
        val archivo = File("C:\\Users\\Usuario\\Desktop\\Jugadores\\$nombre.txt")
        archivo.writeText(toJson())
    }

    private fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }
}

fun cargarJugador(nombre: String): Jugador{
    return try {
        val archivo = File("C:\\Users\\Usuario\\Desktop\\Jugadores\\$nombre.txt")
        fromJson(archivo.readText())
    } catch (exception : Exception) {
        println("No hay datos disponibles de este jugador")
        Jugador(nombre = nombre)
    }
}

private fun fromJson(json: String) : Jugador {
    val gson = Gson()
    return gson.fromJson(json, Jugador::class.java)
}