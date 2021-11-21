package Examen.FuncionesRunApplyETCProfe

import com.google.gson.Gson

data class Personaje(var nombre : String, var edad : Int) {

    companion object {
        fun fromJson(json:String) : Personaje {
            val gson = Gson()
            return gson.fromJson(json, Personaje::class.java)
        }
    }

    fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

}