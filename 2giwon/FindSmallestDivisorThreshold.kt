import kotlin.math.ceil

class FindSmallestDivisorThreshold {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var left = 1
        var right = 1000001

        while (left <= right) {
            val mid = left + (right - left) / 2
            val sum = sum(nums, mid)
            if (sum > threshold)
                left = mid + 1
            else
                right = mid - 1
        }

        return left
    }

    private fun sum(nums: IntArray, d: Int): Int {
        var sum = 0
        for (num in nums) {
            sum += ceil(num.toDouble() / d).toInt()
        }
        return sum
    }
}