package Examen

fun main() {

    // Transforma las siguientes funciones ne Lambdas. Todas las lambdas deben estar dentro de main
    val list = listOf<Any>("1",2);

    val ejercicio1 = {println("Hola")}
    ejercicio1()
    val ejercicio2 = {integer : Int -> println("Hola $integer")}
    ejercicio2(1)
    val ejercicio3 =  {integer : Int, listInteger : List<Any> -> println("Hola ${integer + listInteger.size}")}
    ejercicio3(1, list)
    val ejercicio4 : (Int, List<Any>) -> Int = { integer: Int, listInteger: List<Any> -> integer + listInteger.size}
    println("El numero es ${ejercicio4(1,list)}")
}


fun ejercicio1() {
    println("Hola")
}

fun ejercicio2(integer : Int) {
    println("Hola $integer")
}

fun ejercicio3(integer : Int, listInteger : List<Any>) {
    println("Hola ${integer + listInteger.size}")
}

fun ejercicio4(integer : Int, listInteger : List<Any>) : Int {
    return integer + listInteger.size
}
