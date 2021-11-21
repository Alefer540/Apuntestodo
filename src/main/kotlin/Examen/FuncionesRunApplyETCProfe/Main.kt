package Examen.FuncionesRunApplyETCProfe

fun main() {

    val p1 = Personaje("Paquito", 1)

    var numero1 = p1.let{
        println("Hola soy un let y tengo dento a $it")
        it.edad
    }

    var numero2 = with(p1){
        println("Hola soy un let y tengo dento a $this")
        edad
    }

    var numero3 = p1.run {
        println("Hola soy un let y tengo dento a $this")
        edad
    }

    var numero4 = run {
        println("Hola soy un let y tengo dento a $p1")
        p1.edad
    }

    var p3 = p1.apply {
        println("Hola soy un let y tengo dento a $p1")
        edad
    }

    var p4 = p1.also {
        println("Hola soy un let y tengo dento a $p1")
        it.edad
    }
}