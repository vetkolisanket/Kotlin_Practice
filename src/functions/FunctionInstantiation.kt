package functions

/**
 * Non-literal values of function types with and without receiver are interchangeable, so that the receiver can stand in
 * for the first parameter, and vice versa. For instance, a value of type (A, B) -> C can be passed or assigned where
 * a A.(B) -> C is expected and the other way around:
 */
val repeatFun: String.(Int) -> String = {times -> this.repeat(times)}
val twoParameters: (String, Int) -> String = repeatFun

/**
 * If the value has a receiver type, the receiver object should be passed as the first argument. Another way to invoke a
 * value of a function type with receiver is to prepend it with the receiver object, as if the value were an extension function:
 */
val stringPlus: (String, String) -> String = String::plus
val intPlus: Int.(Int) -> Int = Int::plus

/**
 * You can use either of repeatFun or twoParameters as an argument to runTransformation
 */
fun runTransformation(f: (String, Int) -> String): String {
    return f("hello", 3)
}

fun main() {
//    val result = runTransformation(repeatFun)
    val result = runTransformation(twoParameters)
    println(result)

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call
}