
import kotlin.math.sqrt

fun main(){
    println("Primer programa en kotlin")

    val a :Long =13

    var b :Double = a.toDouble()

    var c :Int = 19

    var d :String = "Antoo"

    var e :Double = -3.00

    var z :Int = 100

    println("Mi numero favorito es el $a")


    println("Mi numero es $b pero no me gusta")

    println(convertir(c))
    println(juntar("Antonio"))
    println(doblee("Antonio",c))
    comprobador(c,d)
    operadores(e)
    println(convierte(z))

println("Voy ha hacer una torre con 4 pisos y 3 ventanas")

    torre(4,3)

}

fun torre(number : Int,numberr : Int){
    repeat(numberr*3+2) {
        print("_")
    }
    println("")
        repeat(number){
            print("|")
            repeat(numberr){
                print("_0_")
            }
            print("|")
            println("")
        }
    }





fun convertir(number : Int): Double{
    var a :Double = number.toDouble()

    return a
}

fun juntar(frase : String): String{


    return "Hola $frase"
}

fun doblee(frase : String, number :Int): String{


    return "Hola soy $frase y tengo $number años"
}
fun comprobador(nume: Int, cade :String){

    if (nume <= 18) println("$cade Es menor de edad")
    else if (nume >= 18 && nume <=65 ) println("$cade Esta entre 18 y 65")
    else println("$cade Es mayor de 65")

when (nume){
    in 0..18 ->   println("$cade Es menor de edad")
    in 18..65 -> println("$cade Esta entre 18 y 65")
    else -> println("$cade Es mayor de 65")
}
}

fun operadores(num :Double) {

    var j = num
    if (num == 0.00) j=0.00
    else if (num > 0.00) j= (j*2) +3
    else j = (j/2) -3

    println("Te devuelvo $j")

    if (num % 2 == 0.00) println("Es par")
    else println("Es impar")

}

fun convierte(num :Int) {

 repeat(num){
     print(it.toChar())
     if (it  % 10 == 0)
         println()



 }


}



