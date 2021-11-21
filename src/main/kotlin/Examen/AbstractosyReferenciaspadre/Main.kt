package Examen.AbstractosyReferenciaspadre

fun main() {

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

    override fun funDelPadre() {
        super.funDelPadre()
        println("Se ha llamado a la función del hijo")
    }

    override fun funAbstracta() {
        println("Esto es una función abstracta")    }


}

abstract class ClasePadre {
    val atributoPadre = 1
    open fun funDelPadre() {
        println("Se ha llamado a la función del hijo")
    }

    abstract fun funAbstracta()
}