package Examen.Interfaces

fun main() {
    val a = ClasePadre()
    a.diHola()
    println(a.atributoPadre)
    a.diAdios()
    val b = ClaseHija()
    b.diHola()
    println(b.atributoPadre)
    println(b.atributoHijo)
    b.diAdios()
    // No se puede ya que ClasePadre es abstracto
    // val c = ClasePadreAbstracto()
    val d = ClaseHijaAbstracta()
    println(d.atributoPadre)
    println(d.atributoHijo)
    d.funAbstracta()
    val e = ClaseImplementaInterfaz()
}

open class ClasePadre {
    val atributoPadre = 1
    fun diAdios(){
        println("Adios")
    }
    open fun diHola(){
        println("Hola")
    }
}
class ClaseHija : ClasePadre() {
    val atributoHijo = 2
    override fun diHola(){
        println("Saludos")
    }
}

abstract class ClasePadreAbstracto {
    val atributoPadre = 3
    abstract fun funAbstracta()
}
class ClaseHijaAbstracta : ClasePadreAbstracto() {
    val atributoHijo = 4
    override fun funAbstracta() {
        println("Soy funAbstracta")
    }
}
interface MyInterface1 {
    fun funInterface1()
}
interface MyInterface2 {
    fun funInterface2()
}
class ClaseImplementaInterfaz : MyInterface1, MyInterface2 {
    override fun funInterface1() {
        println("Soy funInterface1")
    }
    override fun funInterface2() {
        println("Soy funInterface1")
    }
}