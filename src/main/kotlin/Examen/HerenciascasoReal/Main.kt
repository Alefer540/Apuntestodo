package Examen.HerenciascasoReal

fun main() {
    val listaPersonajes : MutableList<Personaje> = mutableListOf()

    listaPersonajes.add(crearGandalf())
    listaPersonajes.add(crearAragorn())
    listaPersonajes.add(crearLegolas())
    crearFrodo()?.let { listaPersonajes.add(it) }
    crearSam()?.let { listaPersonajes.add(it) }

    print(listaPersonajes)
    listaPersonajes.forEach {
        it.mostrarDetallesPorPantalla()
    }
}


fun crearLegolas(): Elfo {
    return Elfo("Legolas", 179)
}

fun crearAragorn(): Humano {
    return Humano(
        "Aragorn, hijo de Arathorn, heredero de Isildur, señor de los Dunedain, heredero del trono de Gondor, apodado Trancos, Capitán de los Montaraces del norte",
        185
    )
}

fun crearFrodo(): Hobbit? {
    return crearHobbit("Frodo", 140)
}

fun crearSam(): Hobbit? {
    return crearHobbit("Sam", 180)
}

fun crearHobbit(nombre : String, altura : Int): Hobbit? {
    return try {
        Hobbit(nombre, altura)
    } catch (e : java.lang.Exception) {
        null
    }
}

fun crearGandalf(): Mago {
    return Mago("Gandalf", 180)
}

class Mago internal constructor(nombre: String, altrua: Int) :
    Personaje(nombre, Mago::class.java.simpleName, altrua) {
    override fun getTamanoPaso(): Int {
        return 50
    }
}

class Humano internal constructor(nombre: String, altrua: Int) :
    Personaje(nombre, Humano::class.java.simpleName, altrua) {
    override fun getTamanoPaso(): Int {
        return 50
    }
}

class Hobbit internal constructor(nombre: String, altrua: Int) :
    Personaje(nombre, Hobbit::class.java.simpleName, altrua) {
    override fun getTamanoPaso(): Int {
        return 25
    }

    init {
        if (altrua > 160) {
            throw Exception("Eso es no es un Hobbit...")
        }
    }
}

class Elfo internal constructor(nombre: String, altrua: Int) :
    Personaje(nombre, Elfo::class.java.simpleName, altrua) {
    override fun getTamanoPaso(): Int {
        return 50
    }
}