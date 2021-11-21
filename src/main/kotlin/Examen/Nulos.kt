package Examen

fun main() {
    //Tiene protección contra nulos.
    //Es necesario especificar qué variables podrán tomar valor nulo. Utilizamos el “?” para ello.
    //val variableNullable : Int? = null
    //No podremos utilizar los métodos de la “variableNullable” hasta asegurar que no es null.
    //Principales Alternativas:
    //“?” llama a las funciones de forma segura:
    //numero?.toLong()
    //La función toLong() sólo se llamará si numero no es null. En caso de ser null, no hará nada.
    //“!!” - fuerza la llamada asumiendo que no es null:
    //numero!!.toLong()
    //En caso de ser null, tendríamos una excepción: NullPointerException.
    //“?.let” - se verá en detalle más adelante:
    //numero?.let { println("Es número recibido es... $it")}
    //La combinación “:?” sirve para ofrecer una alternativa en caso de que sea Null.
    //La variable será 1 si variableNullable es Null:
    //val variable = variableNullable?: 1
    //La función devolverá 0 si i es Null:
    //return i ?: 0

    // Kotlin exige el operador ? para que una variable pueda tomar el valor null
    val variableNullable : Int? = null
    // variableNullable.toLong() // No compila ya que toLong requiere que variable3 sea no null.
    avoidNullExceptionIfNumeroIsNull(variableNullable)
    forceNullExceptionIfNumeroIsNull(variableNullable)
    avoidNullWithLet(variableNullable)
    // variableNoNullable es de tipo Int
    val variableNoNullable = getInt(variableNullable)
    val variable = variableNoNullable?: 1

}

fun getInt(numero : Int?) : Int{
    // Si numero es null, entonces devuelve 0. En caso contrario devuelve el valor de numero.
    return numero?: 0
}

fun avoidNullExceptionIfNumeroIsNull(numero : Int?){
    println("El número recibido es... ${numero?.toLong()}")
    // toLong() no se ejecuta si numero es null
}

fun forceNullExceptionIfNumeroIsNull(numero : Int?){
    try {
        print("El número recibido es... ${numero!!.toLong()}")
    } catch (exception : NullPointerException) {
        println("Excepción capturada")
    }
}

fun avoidNullWithLet(numero: Int?){
    numero?.let {
        println("El número recibido es... $it")
    }
}