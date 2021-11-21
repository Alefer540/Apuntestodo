package Examen

fun main() {

    // Vamos a crear una clase que te permite llevar un contador.
    // Para crear una variable del tipo ClasePersonalizada usaremos:
    val miObjeto = ClasePersonalizada()

    // Cómo incremento es público, podemos modificarlo.
    miObjeto.incremento = 2

    // Cómo total es privado, no hay forma de modificarlo, daría error.
    // miObjeto.total = 2

    // Cómo suma es público, podemos llamarla.
    do {
        miObjeto.suma()
    } while (!miObjeto.seHaReiniciado())

    // Cómo comprobarReinicioVariablePrivada es privado, no hay forma de modificarlo, daría error.
    // miObjeto.comprobarReinicioVariablePrivada()


    for (i in 0 until 10) {
        println("====== Iteración $i =======")
        miObjeto.incremento = i
        do {
            miObjeto.suma()
        } while (!miObjeto.seHaReiniciado())
    }
}

class ClasePersonalizada(){
    var incremento = 1
    private val valorMaximo = 10
    private var total = 0

    fun suma() {
        print("Sumando $total + $incremento cuyo resultado es ")
        total+= incremento
        println(total)

        // Cómo estamos dentro de la clase, no hace falta poner nada para llamar a "comprobarReinicioVariablePrivada()"
        // Además, podemos llamar a "comprobarReinicioVariablePrivada()" aunque sea privada.
        comprobarReinicioVariablePrivada()
    }

    private fun comprobarReinicioVariablePrivada(){
        if (total >= valorMaximo) {
            println("Reinicando el contador")
            total = 0
        }
    }

    fun seHaReiniciado() : Boolean {
        return total == 0
    }

}