package Examen.Dados1

fun main() {
    //Crea una clase dado.
    //Tendrá que tener un número mínimo y máximo que sean privados. Crea una función que permita cambiar estos dos valores a la vez.
    //Haz una función que se llame tiradaUnica que devuelve un resultado dentro del rango del dado.
    //Haz una función que se llame tiradaMultiple. En este caso se tirará dos veces el dato y devolverá la suma de los dos números salvo que haya obtenido dos números iguales, en ese caso devolverá la multiplicación de ambos números.
    //Créate un segundo dado que tenga distintos valores que el anterior sin modificar el dado anterior.
    //Realiza una tirada de ambos dados.

    val dado1 = Dado()
    val dado2 = Dado()

    dado1.darValores(3,4)
    dado2.darValores(0,30)

    println("El dado1 ha obtenido un en tiradaUnica ${dado1.tiradaUnica()}")
    println("El dado1 ha obtenido un en tiradaDoble ${dado1.tiradaDoble()}")

    println("El dado2 ha obtenido un en tiradaUnica ${dado2.tiradaUnica()}")
    println("El dado2 ha obtenido un en tiradaDoble ${dado2.tiradaDoble()}")

}