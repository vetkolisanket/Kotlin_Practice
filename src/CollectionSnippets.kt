import java.util.*

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    arrayList.sortWith(Comparator { o1, o2 -> o2 - o1 })
    return arrayList
}


inline fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun main() {
    val items = listOf(1,2,3,4,5)

    items.fold(0) { acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        result
    }

    val joinedString = items.fold("Elements") { acc, i ->
        "$acc $i"
    }

    println(joinedString)

    val product = items.fold(1, Int::times)

    println(product)

    println(getList())
}