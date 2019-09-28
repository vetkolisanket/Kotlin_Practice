package sequence

val bigBoxOfCrayons = setOf(
    Crayon("marigold"),
    Crayon("lime"),
    Crayon("red"),
    Crayon("yellow"),
    Crayon("blue"),
    Crayon("orange"),
    Crayon("grape"),
    Crayon("white"),
    Crayon("red-violet"),
    Crayon("pond"),
    Crayon("cinnamon"),
    Crayon("neon lightning"),
    Crayon("metal"),
    Crayon("violet"),
    Crayon("charcoal"),
    Crayon("brick"),
    Crayon("green"),
    Crayon("silver")
)

val includedColors =
    setOf("brick", "marigold", "neon lightning", "orange", "red", "red-violet", "white", "yellow")

/**
 * Start with the big box
 * Filter out colors that don’t apply
 * Label the crayons
 * Take just the first five crayons
 * Collect them into their final box
 */

val fireSet = bigBoxOfCrayons
    .filter { it.color in includedColors }
    .map { it.copy(label = "New!") }
    .take(5)
    .toSet()

val fireSetSeq = bigBoxOfCrayons
    .asSequence()
    .filter { it.color in includedColors }
    .map { it.copy(label = "New!") }
    .take(5)
    .toSet()

fun main() {
    println(fireSet)
    println(fireSetSeq)
}