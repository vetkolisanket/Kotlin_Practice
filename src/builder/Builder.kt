package builder

fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0 }
    val isOdd: Int.() -> Boolean = { this % 2 == 1 }

    return listOf(42.isOdd(), 239.isOdd(), 233524234.isEven())
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun buildMap(build: HashMap<Int, String>.() -> Unit): HashMap<Int, String> {
    val map = hashMapOf<Int, String>()
    map.build()
    return map
}

fun main() {
    print(usage())
}