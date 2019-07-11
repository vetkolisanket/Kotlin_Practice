data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) {
    //Used for operator overloading, in this case '<'
    operator fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    //Used for operator overloading, in this case 'in'
    operator fun contains(item: MyDate): Boolean = start <= item && item <= endInclusive
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in DateRange(first, last)
}

fun main() {
    println(compare(MyDate(1,1,1), MyDate(2,1,1)))
    println(checkInRange(MyDate(2,1,1), MyDate(1,1,1), MyDate(3,1,1)))
}