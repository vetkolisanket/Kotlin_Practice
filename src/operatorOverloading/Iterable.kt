package operatorOverloading

import java.util.*

data class MyDate3(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate3> {
    override fun compareTo(other: MyDate3) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate3.rangeTo(other: MyDate3) = DateRange3(this, other)

class DateRange3(val start: MyDate3, val end: MyDate3) : Iterable<MyDate3> {
    override fun iterator(): Iterator<MyDate3> = DateIterator(this)
}

class DateIterator(val dateRange3: DateRange3): Iterator<MyDate3> {

    var current = dateRange3.start

    override fun hasNext() = current <= dateRange3.end

    override fun next(): MyDate3 {
        val result = current
        current = current.nextDay()
        return result
    }
}

fun iterateOverDateRange(firstDate: MyDate3, secondDate: MyDate3, handler: (MyDate3) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}

/*fun printDate(date3: MyDate3) {
    println(date3)
}*/

val printDate: (MyDate3) -> Unit = {println(it)}

fun main() {
    iterateOverDateRange(MyDate3(2001, 2,21), MyDate3(2001, 3, 4), printDate)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

fun MyDate3.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate3 {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when (timeInterval) {
        TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, number)
        TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, number)
        TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
    }
    return MyDate3(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE))
}

fun MyDate3.nextDay() = addTimeIntervals(TimeInterval.DAY, 1)