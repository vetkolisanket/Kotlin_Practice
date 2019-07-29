package properties

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("<no name>") {
        property, oldValue, newValue -> println("$property from $oldValue -> $newValue")
    }

    var age: Int by Delegates.vetoable(0) {
        property, oldValue, newValue ->
        if (newValue < 0) {
            println("Can't assign negative value for age")
            false
        } else {
            println("$property from $oldValue -> $newValue")
            true
        }
    }

    override fun toString(): String {
        return "Name: $name, Age: $age"
    }
}

fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"

    user.age = 55
    user.age = -55

    println(user)
}