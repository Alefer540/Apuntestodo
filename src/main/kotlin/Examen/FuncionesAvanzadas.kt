package Examen

fun main() {
    funPolimorfica()
    funPolimorfica(1)
    funValorPorDefecto()
    funValorPorDefecto(1)
    funValorPorDefectoMultiple(1)
    funValorPorDefectoMultiple(1,1)
    funValorPorDefectoMultiple(integer2 = 1)
    funValorPorDefectoMultiple(integer2 = 1, integer1 = 2)
}

fun funPolimorfica() {
    println("Soy la funPolimorfica() sin argumentos")
}

fun funPolimorfica(integer : Int) {
    println("Soy la funPolimorfica() con argumentos")
}

fun funValorPorDefecto(integer : Int = 15) {
    println("El valor recibido es $integer")
}

fun funValorPorDefectoMultiple(integer1 : Int = 15, integer2 : Int = 10) {
    println("El valor recibido en integer1 es $integer1")
    println("El valor recibido en integer2 es $integer2")
}