package conventions

data class MyDate4(val year: Int, val month: Int, val dayOfMonth: Int)

fun isLeapDay(date: MyDate4): Boolean {

    val (year, month, dayOfMonth) = date

    // 29 February of a leap year
    return year % 4 == 0 && month == 2 && dayOfMonth == 29
}

fun main() {
    println(isLeapDay(MyDate4(2019, 2, 23)))
    println(isLeapDay(MyDate4(2020, 2,29)))
}