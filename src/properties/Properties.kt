package properties

//Custom setter example
class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            field = value
            counter++
        }
}

//Custom lazy property
class LazyProperty(val initializer: () -> Int) {

    var value: Int? = null

    val lazy: Int
        get() {
            if (value == null) {
                value = initializer()
            }
            return value!!
        }

}