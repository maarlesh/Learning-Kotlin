package basics

class SecondLargest {
    fun getLargest(arr : MutableList<Int>) : Int{
        var result = -1
        for (i in 0..<arr.size){
            if(result < arr[i]){
                result = arr[i]
            }
        }
        return result
    }
    // O(n) solution
    fun getNLargest(arr : MutableList<Int>) : Int{
        var largest : Int = Int.MIN_VALUE
        var secondLargest : Int = Int.MIN_VALUE
        for (i in 0..<arr.size){
            if(largest < arr[i]){
                secondLargest = largest
                largest = arr[i]
            }else if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i]
            }
        }
        return if(secondLargest != Int.MIN_VALUE){
            secondLargest
        }else{
            // Array contains same elements
            -1
        }
    }
}

fun main(){
    println("Enter range n:")
    val n = readln().toInt()
    val arr : MutableList<Int> = ArrayList(n)
    println("Enter the element one by one")
    repeat(n){
        val element = readln().toInt()
        arr.add(element)
    }
    val result = SecondLargest().getNLargest(arr)
    println("Second largest result: $result")
}