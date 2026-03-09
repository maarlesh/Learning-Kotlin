package basics

class FrequencyCounter {

    // O(n2)
    fun getFrequencies(arr: MutableList<Int>) : HashMap<Int,Int>{
        val result : HashMap<Int,Int> = HashMap<Int,Int>(arr.size)
        for(i in arr){
            var occurrences = 0;
            for(j in arr){
                if(i == j){
                    occurrences++;
                }
            }
            result[i] = occurrences;
        }
        return result;
    }

    // O(n)
    fun getFrequencies2(arr: MutableList<Int>) : HashMap<Int,Int>{
        val result : HashMap<Int,Int> = HashMap<Int,Int>(arr.size)
        for(i in arr){
            result[i] = result.getOrDefault(i,0) + 1;
        }
        return result;
    }
}

fun main(){
    val arrayInput : ArrayInput = ArrayInput()
    val arr = arrayInput.getArray()
    print(arr.joinToString(","))
    val result = FrequencyCounter().getFrequencies(arr);
//    print("Occcurences: $result")
    print(FrequencyCounter().getFrequencies2(arr))
}