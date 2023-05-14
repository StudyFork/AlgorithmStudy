import kotlin.math.max

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var sum = nums[0]
        var sub = 0
        for (num in nums) {
            sub = if (sub < 0) num else (sub + num)
            sum = max(sum, sub)
        }

        return sum
    }
}
