class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val result = IntArray(k)
        var targetIndex = 0
        for (i in nums.indices) {
            while (
                targetIndex > 0 && 
                result[targetIndex - 1] > nums[i] && 
                targetIndex - i + nums.lastIndex >= k
            ) {
                targetIndex--
            }
            if (targetIndex < k) {
                result[targetIndex++] = nums[i]
            }
        }
        return result
    }
}
