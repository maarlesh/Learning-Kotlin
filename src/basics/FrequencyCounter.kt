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

    fun getDuplicateElements(arr: MutableList<Int>){
        val map = this.getFrequencies2(arr)
        println("Duplicate elements are: ")
        for ((key,value) in map){
            if(value > 1){
                println("$key ")
            }
        }
    }

    fun getFrequenciesOfWords(str : String) : HashMap<String,Int>{
        val map: HashMap<String, Int> = hashMapOf()
        val words = str.split(" ")
        for(i in words){
            map[i] = (map[i] ?: 0) + 1
        }
        return map
    }
}

fun main(){
    val arrayInput : ArrayInput = ArrayInput()
    val arr = arrayInput.getArray()
    println(arr.joinToString(","))
    val result = FrequencyCounter().getFrequencies(arr);
//    print("Occcurences: $result")
    println(FrequencyCounter().getFrequencies2(arr))
    FrequencyCounter().getDuplicateElements(arr);
}