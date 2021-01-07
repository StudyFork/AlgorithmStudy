class Solution {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        nums.sort()
        var (min, max) = 1 to nums.last()
        while (min < max) {
            val mid = (min + max) / 2
            val sum = nums
                .asSequence()
                .map(Int::toDouble)
                .fold(0.0) { acc, i ->
                    acc + (Math.ceil(i.div(mid.toDouble())))
                }
                .toInt()
            if (sum > threshold) min = mid + 1 else max = mid
        }
        return min
    }
}
