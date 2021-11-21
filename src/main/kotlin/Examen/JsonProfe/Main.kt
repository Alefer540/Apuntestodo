package Examen.JsonProfe

fun main() {

    val p1 = Personaje("Paquito", 1)

    println(p1)
    println(p1.toJson())

    val json1 = "{\"nombre\":\"Rodolfo\",\"edad\":2}"
    val p2 = Personaje.fromJson(json1)

    println(p2)
}