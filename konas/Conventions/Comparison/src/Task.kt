data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    //    override fun compareTo(other: MyDate): Int {
//        // java style
//        if(year == other.year){
//            if(month == other.month){
//                return dayOfMonth.compareTo(other.dayOfMonth)
//            }
//            return month.compareTo(other.month)
//        }
//        return year.compareTo(other.year)
//    }
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year.compareTo(other.year)
        month != other.month -> month.compareTo(other.month)
        else -> dayOfMonth.compareTo(other.dayOfMonth)
    }

}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
