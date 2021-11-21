package Examen.DataClass

fun main() {
    val normalClass = GuessNormalClass("Peter", 1)
    println(normalClass)
    // println prints the normalClass' hash instance.
    val dataClass = GuessDataClass("John", 2)
    println(dataClass)
    // println prints the dataClass' content.

    normalClass.funExample()

    dataClass.funExample()

    //----- The normal class can't do the following

    // normalClass.component1()
    println(dataClass.component1())
    println(dataClass.component2())

    val (comp1, comp2) = dataClass
    println(comp1)
    println(comp2)


    val dataClassCopy = dataClass.copy()

    println(dataClass.hashCode())
    println(dataClassCopy.hashCode())

    if (dataClass == dataClassCopy) {
        println("Both objects are equals")
    } else {
        println("Different object")
    }

    dataClassCopy.name= "Alfred"
    println(dataClass.hashCode())
    println(dataClassCopy.hashCode())

    if (dataClass == dataClassCopy) {
        println("Both objects are equals")
    } else {
        println("Different object")
    }

}