package Examen

fun main(args: Array<String>) {
    operatorIs()
    operatorAs()
}


fun operatorIs(){
    println("--- OperatorIs ---")

    val myInteger = 10
    println("myInterger is an integer and split by 2 is  ${myInteger.div(2)}")
    if (myInteger is Int) {
        println("Go into the first if.")
    }

    val myNumber : Number = myInteger
    // La siguiente línea no compilaría ya que Number no tiene le método div
    // println("myNumber is an Number and split by 2 is ${myNumber.div(2)}")

    if (myNumber is Int) {
        println("myNumber is an Integer and split by 2 is ${myNumber.div(2)}")
    }

    if (myNumber !is Int) {
        println("This should not be called")
    }
}


fun operatorAs(){
    println("--- OperatorAs ---")

    val myInteger = 10
    println("myInterger is an integer and split by 2 is  ${myInteger.div(2)}")
    val myNumber1 : Number = myInteger
    // La siguiente línea no compilaría ya que Number no tiene le método div
    // println("myNumber is an Number and split by 2 is ${myNumber.div(2)}")
    myNumber1 as Int
    println("myNumber1 is an Integer and split by 2 is ${myNumber1.div(2)}")

    val myFloat = 2.2
    println("myFloat is an integer and split by 2 is ${myFloat.div(2)}")

    // Es posible hacer casting de numeros, pero no es recomedable.
    val myNumber2 : Number = myInteger
    myNumber2 as Int
    println("myNumber2 is $myNumber2")


    val myString = "Hola"
    println("myString is $myString")

    // El operador as lanzarían una excepción ClassCastException ya que un String no se puede transformar en un Int de este modo.
    try {
        val myNumber4 = myString as Int
    } catch (exception : ClassCastException) {
        println("Excepción capturada")
    }

    // Con as?, en caso de que no pueda realizarse el casting, entonces devuelve null.
    val myNumber4 = myString as? Int
    println("myNumber4 is $myNumber4")
}