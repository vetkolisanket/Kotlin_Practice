/**
 * Non-literal values of function types with and without receiver are interchangeable, so that the receiver can stand in
 * for the first parameter, and vice versa. For instance, a value of type (A, B) -> C can be passed or assigned where
 * a A.(B) -> C is expected and the other way around:
 */
val repeatFun: String.(Int) -> String = {times -> this.repeat(times)}
val twoParameters: (String, Int) -> String = repeatFun

/**
 * You can use either of repeatFun or twoParameters as an argument to runTransformation
 */
fun runTransformation(f: (String, Int) -> String): String {
    return f("hello", 3)
}

fun main() {
    val result = runTransformation(twoParameters)
    println(result)
}