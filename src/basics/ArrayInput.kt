package basics

class ArrayInput {
    fun getArray() : MutableList<Int>{
        print("Enter size of the array:")
        val n = readln().toInt()
        val arr : MutableList<Int> = ArrayList<Int>(n)
        print("Enter element one by one")
        repeat(n){
            val element = readln().toInt()
            arr.add(element)
        }
        return arr
    }
}