package Examen.DataClass

// Exercises:
// Read the following classes and decide if transforming them in a data class is worthy.

class Person1(val name : String, val surname : String) {}

class Person2() {

    val name : String
    val surname : String

    init {
        println("Insert your name: ")
        name = readLine().toString()
        println("Insert your surname: ")
        surname = readLine().toString()

    }
}

open class Person3(val name : String, val surname : String) { }