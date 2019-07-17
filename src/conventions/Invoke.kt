package conventions

/*
Objects with invoke() method can be invoked as a function.

You can add invoke extension for any class, but it's better not to overuse it
 */
class Invokable {
    var numberOfInvokations = 0
    private set

    operator fun invoke(): Invokable {
        numberOfInvokations++
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()

fun main() {
    val invokable = Invokable()
    invokeTwice(invokable)
    println(invokable.numberOfInvokations)
}