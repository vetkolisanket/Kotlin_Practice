package conventions

data class MyDate2(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate2> //Needed for .. operator
{
    //Used for operator overloading, in this case '<'
    override operator fun compareTo(other: MyDate2): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate2.rangeTo(other: MyDate2) = DateRange2(this, other)

class DateRange2(override val start: MyDate2, override val endInclusive: MyDate2): ClosedRange<MyDate2> //Needed for .. operator

fun compare(date1: MyDate2, date2: MyDate2) = date1 < date2

fun checkInRange(date: MyDate2, first: MyDate2, last: MyDate2): Boolean {
    return date in first..last
}

fun main() {
    println(compare(MyDate2(1,1,1), MyDate2(2,1,1)))
    println(checkInRange(MyDate2(2,1,1), MyDate2(1,1,1), MyDate2(3,1,1)))
}