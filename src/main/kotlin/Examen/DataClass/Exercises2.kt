package Examen.DataClass

// Exercises:
// Read the following classes and answer the following questions.

class User1(var name : String, var password : String) {}
data class User2(var name : String, var password : String) {}


fun question1() {
    // Which text is going to be written? user1a == user1b or user1a != user1b
    val user1a = User1("Carlos", "1234")
    val user1b = User1("Carlos", "1234")
    if (user1a == user1b) {
        println("user1a == user1b")
    } else {
        println("user1a != user1b")
    }
}


fun question2() {
    // Which text is going to be written? user1a == user1b or user1a != user1b
    val user2a = User2("Carlos", "1234")
    val user2b = User2("Carlos", "1234")
    if (user2a == user2b) {
        println("user1a == user1b")
    } else {
        println("user1a != user1b")
    }
}

fun question3() {
    // Which text is going to be written?
    val user1a = User1("Carlos", "1234")
    val user1b = user1a
    user1b.name = "John"
    user1b.password = "4321"

    println("user1a -> My name is ${user1a.name} and my password is ${user1a.password}")
    println("user1b -> My name is ${user1b.name} and my password is ${user1b.password}")
}

fun question4() {
    // Which text is going to be written?
    val user2a = User2("Carlos", "1234")
    val user2b = user2a.copy()
    user2b.name = "John"
    user2b.password = "4321"

    println("user1a -> My name is ${user2a.name} and my password is ${user2a.password}")
    println("user1b -> My name is ${user2b.name} and my password is ${user2b.password}")
}