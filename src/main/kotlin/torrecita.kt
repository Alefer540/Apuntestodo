import kotlin.math.sqrt

fun main(){

    var numeroPisos =10
    var numeroVentanas=4


    print(creaRascacielos(numeroPisos,numeroVentanas))
    println("")
    println("")
    creaPiramides(10)
}

fun creaRascacielos(number : Int,numberr : Int): String {
    var resultado = "";
    repeat(numberr * 3 + 2) {
       resultado=resultado+ "_"
    }
    resultado=resultado+ "\n"
    repeat(number) {
        resultado=resultado+ "|"
        repeat(numberr) {
            resultado=resultado+"_▋_"
        }
        resultado=resultado+"|"
        resultado=resultado+ "\n"
    }
    return resultado
}

fun creaPiramides(number : Int){
    var espacios=0
    espacios=number
    repeat(number){ ir->
        repeat(espacios) {
            print(" ")
        }
        print("/")
        repeat(ir) {
            print("__")
        }
        print("\\")
        println("")
        espacios =espacios-1
    }
}

