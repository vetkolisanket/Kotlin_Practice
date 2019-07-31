package properties

class UserInfo(private val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main() {
    val userInfo = UserInfo(mapOf(
        "name" to "John Doe",
        "age" to 25
    ))

    println(userInfo.name)
    println(userInfo.age)
}

class MutableUser(private val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}