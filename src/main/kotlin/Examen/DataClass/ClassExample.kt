package Examen.DataClass

class GuessNormalClass(var name : String, var bedroom : Int) {
    private val summary = "$name has the bedroom nº $bedroom"

    fun funExample() {
        println("${javaClass.name}: $summary")
    }
}

data class GuessDataClass(var name : String, var bedroom : Int) {
    private val summary = "$name has the bedroom nº $bedroom"

    fun funExample() {
        println("${javaClass.name}: $summary")
    }
}