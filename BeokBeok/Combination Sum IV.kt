class Solution {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val result = Array(target + 1) { 0 }.also {
            it[0] = 1
        }
        for (i in 1 until result.size) {
            for (j in nums.indices) {
                if (i - nums[j] >= 0) result[i] += result[i - nums[j]]
            }
        }
        return result[target]        
    }
}
