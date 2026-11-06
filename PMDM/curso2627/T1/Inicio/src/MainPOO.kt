import model.User

fun main() {
    println("Ejemplo de POO")
    val user = User(name = "Borja")
    // name = "Borja" surname = "" phone = null
    val user1 = User("Marta", "Lopez")
    // name = "Marta" surname = "Lopez" phone = null
    val user2 = User("Julia", "Lopez", 1234)
    // name = "Julia" surname = "Lopez" phone = 1234
    val lista = arrayListOf<User>()
    lista.add(user)
    lista.add(user1)
    lista.add(user2)
    for (data in lista) {
        data.showData()
    }

    lista.forEach { item -> item.showData() }

}