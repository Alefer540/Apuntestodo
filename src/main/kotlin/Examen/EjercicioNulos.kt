package Examen



//funcion1: Debe tener 4 parámetros de entrada (Integers). Si alguno de ellos es null, devuelve null, si no, devuelve la suma de los 4 parámetros.
//funcion2: Debe tener 4 parámetros de entrada (Integers). Devuelve la suma de los 4 parámetros. Si alguno fuera null no se tiene en cuenta. Devuelve cero si todo fuera Null.
//funcion3: Debe tener 4 parámetros de entrada (Integers). Si todos ellos son null, devuelve null, si no, devuelve la suma de los 4 parámetros. Si alguno fuera null no se tiene en cuenta.




fun main() {
    println("======================================================================")
    println("funcion1 = ${funcion1(1,2,3,4)}")
    println("funcion1 = ${funcion1(1,2,3,null)}")
    println("funcion1 = ${funcion1(null,null,null,null)}")
    println("======================================================================")
    println("funcion2 = ${funcion2(1,2,3,4)}")
    println("funcion2 = ${funcion2(1,2,3,null)}")
    println("funcion2 = ${funcion2(null,null,null,null)}")
    println("======================================================================")
    println("funcion3 = ${funcion3(1,2,3,4)}")
    println("funcion3 = ${funcion3(1,2,3,null)}")
    println("funcion3 = ${funcion3(null,null,null,null)}")
    println("======================================================================")
}


fun funcion1(num1: Int?, num2: Int?, num3: Int?, num4: Int?) : Int? {
    return if ( num1 == null || num2 == null || num3 == null || num4 == null)
        null
    else
        num1 + num2 + num3 + num4
}

fun funcion2(num1: Int?, num2: Int?, num3: Int?, num4: Int?) : Int {
    var suma = num1 ?: 0
    suma += num2 ?: 0
    suma += num3 ?: 0
    suma += num4 ?: 0
    return suma
}

fun funcion3(num1: Int?, num2: Int?, num3: Int?, num4: Int?) : Int? {
    return if ( num1 == null && num2 == null && num3 == null && num4 == null)
        null
    else {
        var suma = num1 ?: 0
        suma += num2 ?:0
        suma += num3 ?:0
        suma += num4 ?:0
        suma
    }
}