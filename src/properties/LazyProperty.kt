package properties

class LazyPropert(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}