package basics

class Week {
    fun get(n : Int) : String{
        return when(n){
            1 -> "Monday"
            2 -> "Tuesday"
            3 -> "Wednesday"
            4 -> "Thursday"
            5 -> "Friday"
            6 -> "Saturday"
            7 -> "Sunday"
            else -> "Invalid input"
        }
    }
}

fun main(){
    print("Enter a number (1 to 7)")
    val n = readln().toInt()
    print("Day of the week: ${Week().get(n)}")
}