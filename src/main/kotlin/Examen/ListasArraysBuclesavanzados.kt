package Examen

fun main() {
    managingIntegerList()
    managingStringArrays()
    managingMixList()
    managingListOfList()
    createArrayFromList()
    createListFromArray()
    createListDynamically()
    classicFor(mutableListOf(1,2,3,4,5,6))
    classicForCountingPairs(mutableListOf(1,2,3,4,5,6))
    forCountingPairs(mutableListOf(1,2,3,4,5,6))
    classicForInRanges(mutableListOf(1,2,3,4,5,6))

    //Lista vacia
    var listilla = mutableListOf<Any>()
}

fun managingIntegerList(){
    println("managingIntegerList")
    val list = mutableListOf(1,2,3)
    list.add(5)
    println(list[3])
    list.add(1,10)
    list[0] = 100
    // list = mutableListOf(3) No compila ya que list (el puntero) es de tipo val.

    println(list.toString())
}

fun managingStringArrays() {
    println("managingStringArrays")
    val array = arrayOf("hola", "adios")
    array[1] = "adios!"
    // array[2] = "1" Compila pero da un error ArrayIndexOutOfBoundsException.
    println(array.contentToString())
    // println(array.toString()) Compila pero escribe el puntero en vez del contenido del array
}

fun managingMixList(){
    println("managingMixList")
    val list = mutableListOf(1,2,"a", 2.1)
    list.add(4)
    println(list.toString())
}

fun managingListOfList(){
    println("managingListOfList")
    val list1 = mutableListOf(1,2,"a", 2.1)
    val list2 = mutableListOf(1,2.1)
    val array = arrayOf("hola", "adios")
    val list = mutableListOf(list1, list2, "tres", array)
    list.add(4)
    println(list.toString())
}

fun createArrayFromList() {
    println("createArrayFromList")
    val list = mutableListOf(1,2,3)
    val array = list.toIntArray()
    println(array.contentToString())
}

fun createListFromArray() {
    println("createListFromArray")
    val array = arrayOf(1,2,3,4,5,6)
    val list = array.asList()
    println(list.toString())
}


fun createListDynamically(){
    println("createListDynamically")
    val list = MutableList(99) { pos ->
        if (pos % 2 == 0) pos * -1 else pos
    }
    println(list.toString())
}

fun classicFor(list: Collection<Int>) {
    println("classicFor")

    var totalContent = 0
    for (element in list){
        totalContent += element
    }
    println("La suma total es $totalContent")
}

fun classicForCountingPairs(list: Collection<Int>) {
    println("classicForCountingPairs")

    var totalContent = 0
    for ((element, index) in list.withIndex()){
        if (index % 2 == 0) totalContent += element
    }
    println("La suma de los pares es $totalContent")
}

fun forCountingPairs(list: Collection<Int>) {
    println("forCountingPairs")

    var totalContent = 0
    for (element in list.indices step 2){
        totalContent += element
    }
    println("La suma de los pares es $totalContent")
}

fun classicForInRanges(list: Collection<Int>) {
    println("classicForInRanges")

    for (element in list) {
        print("$element,")
    }
    println()
    for (element in list.indices.reversed()) {
        print("$element,")
    }
    println()
}