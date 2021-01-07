class Solution {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var end = 2
        while (computeSum(nums, end) > threshold) end = end shl 1

        var start = end shr 1
        while (start < end) {
            val mid = start + (end - start) / 2
            if (computeSum(nums, mid) > threshold) start = mid + 1
            else end = mid
        }
        return start
    }

    private fun computeSum(nums: IntArray, i: Int): Long {
        var sum = 0L
        for (num in nums) {
            sum += if (num % i == 0) num / i else num / i + 1
        }
        return sum
    }
}
