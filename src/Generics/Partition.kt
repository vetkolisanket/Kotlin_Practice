package Generics

fun <T> Collection<T>.partitionTo(a: MutableCollection<T>, b: MutableCollection<T>, f: (T) -> Boolean): Pair<Collection<T>, Collection<T>> {
    for (item in this) {
        if (f(item)) {
            a.add(item)
        } else {
            b.add(item)
        }
    }
    return Pair(a, b)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
        partitionTo(ArrayList<String>(), ArrayList()) {
            s -> !s.contains(" ")
        }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLetterAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '{').
            partitionTo(HashSet<Char>(), HashSet()) {
                c -> c in 'a'..'z' || c in 'A'..'Z'
            }
    letters == setOf('a', 'r')
    other == setOf('%', '{')
}