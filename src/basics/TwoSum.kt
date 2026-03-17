//// O(n) - Solution
/* 
1. Create a map 
2. Loop through the array and find the complement for each number
3. Look for the complement in the map
4. If the complement exists return the [complement, index]
5. Else store the num and its corresponding index in the map for future use map[nums[i]] = i
 */

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        nums.forEachIndexed { index, value ->
            val need = target - value
            if (map.containsKey(need)) {
                return intArrayOf(map[need]!!, index)
            }
            map[value] = index
        }

        return intArrayOf()
    }
}