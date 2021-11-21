package Examen.HerenciascasoReal

abstract class Personaje(var nombre: String, nombreraza: String?, altrua: Int) {

    var nombreRaza: String? = nombreraza
    var altura = altrua
    var posicion = 0

    fun mostrarDetallesPorPantalla() {
        println("****$nombre****")
        println("Soy $nombreRaza")
        println("Mido $altura")
        mostrarPosicion()
    }

    fun darPaso() {
        posicion = posicion + getTamanoPaso()
    }

    fun mostrarPosicion() {
        println("Estoy en la posicion $posicion")
    }

    protected abstract fun getTamanoPaso(): Int


    override fun toString() : String {
        return nombre
    }


}