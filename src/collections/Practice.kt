package collections

fun doSomethingStrangeWithCollections(collection: Collection<String>): Collection<String>? {

    val groupsByLength = collection.groupBy { it.length }

    val maximumSizeOfGroup = groupsByLength.values.map { it.size }.max()

    return groupsByLength.values.firstOrNull{ it.size == maximumSizeOfGroup }

}