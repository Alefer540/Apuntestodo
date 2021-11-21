package Examen

fun main(args: Array<String>) {

    // Las lambdas son funciones sin nombre.
    { println("Esto es una lamba vacía. ") } // Nadie ejecuta esta lambda, por lo que que nuca se escribirá

    // Podemos asignar lambdas a funciones.
    val lambda = { println("Esto es una lamba en una variable.") }
    // Y las ejecutamos así.
    lambda()

    // Es posiblre definir parámetros para la lambda.
    val lambdaParametro = { num: Int -> println("He recibido $num como parametro.") }
    // Y las ejecutamos así.
    lambdaParametro(1)

    // En este caso indicamos explicitamente que la lambda requiere de dos parametros Int y que devuelve un Int.
    // Atencion, devuelve la ultima linea de la lambda
    val hazSuma = { num1: Int, num2: Int -> num1 + num2 }
    val hazResta: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 - num2 }

    println("Sumo ${hazSuma(2,1)} como parametro.")
    println("Resto ${hazResta(2,1)} como parametro.")

    println("Sumo ${example(hazSuma)} desde una lambda.")
    println("Resto ${example(hazResta)} desde una lambda.")

}

fun example(functionAsParameter: (Int, Int) -> Int) : Int {
    return functionAsParameter(2,1)
}