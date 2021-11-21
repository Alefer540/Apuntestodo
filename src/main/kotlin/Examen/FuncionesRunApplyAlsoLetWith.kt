package Examen

fun main() {
    functionRun()
    functionWith()
    functionLet()
    functionAlso()
    functionApply()
    functionLetVsAlso()
}



class ClaseEjemplo{
    var int1 : Int = 0
    var int2 : Int = 0
}

fun functionRun(){
    println("--- functionRun ---")

    val i = ClaseEjemplo()

    run {
        i.int1++
        i.int2++
        println("El valor de i dentro del run1 es de ${i.int1} y ${i.int2}")
    }
    println("El valor de i fuera del run1 es de ${i.int1} y ${i.int2}")
    i.run {
        int1++
        int2++
        println("El valor de i dentro del run2 es de $int1 y $int2")
    }
    println("El valor de i fuera del run2 es de ${i.int1} y ${i.int2}")

}

fun functionWith(){
    println("--- functionWith ---")

    val i = ClaseEjemplo()

    with(i){
        int1++
        int2++
        println("El valor de i dentro del with es de $int1 y $int2")
    }
    println("El valor de i fuera del with es de ${i.int1} y ${i.int2}")
}

fun functionLet(){
    println("--- functionLet ---")
    var i : ClaseEjemplo? = null
    i?.let { println("Este mensaje no aparecerá ya que i es null") }

    i  = ClaseEjemplo()
    i.let {
        it.int1++
        it.int2++
        println("El valor de i dentro del let1 es de ${it.int1} y ${it.int2}") }
    println("El valor de i fuera del let1 es de ${i.int1} y ${i.int2}")

    i.let {
        i  = ClaseEjemplo()
        it.int1++
        it.int2++
        println("El valor de i dentro del let2 es de ${it.int1} y ${it.int2}")
        "Este es el resultado de let"
    }
    println("El valor de i fuera del let es de ${i?.int1} y ${i?.int2}")
    val resultado = i.let {
        it?.int1
    }
    println("El resultado de let es $resultado")

    i?.let {contador ->
        println("El numero recibido es $contador")
        // No se puede cambiar el valor de it.
    }
}

fun functionAlso(){
    println("--- functionAlso ---")
    var i : ClaseEjemplo? = null
    i?.also { println("Este mensaje no aparecerá ya que i es null") }

    i  = ClaseEjemplo()
    i.also {
        it.int1++
        it.int2++
        println("El valor de i dentro del let1 es de ${it.int1} y ${it.int2}") }
    println("El valor de i fuera del let1 es de ${i.int1} y ${i.int2}")

    i.also {
        i  = ClaseEjemplo()
        it.int1++
        it.int2++
        println("El valor de i dentro del also2 es de ${it.int1} y ${it.int2}")
    }
    println("El valor de i fuera del also2 es de ${i?.int1} y ${i?.int2}")
    val resultado = i.also {
        it?.int1
    }
    println("El resultado de also3 es ${resultado?.int1}")
    i.also { i?.int1 = 9 }.also { if (i?.int1 == 9) i?.int1 = 8 }
    println("El resultado de also4 es ${resultado?.int1}")

}

fun functionLetVsAlso(){
    println("--- functionLetVsAlso ---")

    val i = ClaseEjemplo()
    val resultado1 = i.let {
        it.int1
    }
    println("El resultado de let es ${resultado1::class.java}")
    val resultado2 = i.also {
        it.int1
    }
    println("El resultado de also es ${resultado2::class.java}")
}

fun functionApply() {
    println("--- functionApply ---")
    val i = ClaseEjemplo()
    i.apply {
        int1++
        int2++
        println("El valor de i dentro del apply es de $int1 y $int2")
    }
    println("El valor de i fuera del apply es de ${i.int1} y ${i.int2}")
}