class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = nums[0]
        var max = nums[0]
        for (i in 1 until nums.size) {
            max = nums[i] + if (max > 0) max else 0
            result = result.coerceAtLeast(max)
        }
        return result
    }
}
