package Examen

fun main() {

    val objetoPadre = ClasePadre()

    // el objeto padre puede:
    println("El padre tiene un atributo que es ${objetoPadre.atributoPadre}")
    objetoPadre.funDelPadre()
    // Sin embargo no podrá (dará error) acceder a la funciones y métodos del hijo ya que directamente no las tiene.
    // println("El padre tiene un atributo que es ${objetoPadre.atributoHijo}")
    // objetoPadre.funDelHijo()

    val objetoHijo = ClaseHija()
    // Puede acceder a las funciones y métodos del padre
    println("El padre tiene un atributo que es ${objetoHijo.atributoPadre}")
    objetoHijo.funDelPadre()
    // Puede acceder a las funciones y métodos del hijo
    println("El padre tiene un atributo que es ${objetoHijo.atributoHijo}")
    objetoHijo.funDelHijo()

}


class ClaseHija : ClasePadre() {
    val atributoHijo = 2
    fun funDelHijo() {
        println("Se ha llamado a la función del Padre siendo ${javaClass.name}")
    }
}

open class ClasePadre {
    val atributoPadre = 1
    fun funDelPadre() {
        println("Se ha llamado a la función del hijo")
    }
}