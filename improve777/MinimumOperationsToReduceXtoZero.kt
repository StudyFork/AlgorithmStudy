import kotlin.math.max

class MinimumOperationsToReduceXtoZero {
    fun minOperations(nums: IntArray, x: Int): Int {
        if (nums.isEmpty()) return -1
        val map = hashMapOf<Int, Int>()  // sum, pos
        map[0] = 0

        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            map[sum] = i
        }

        if (x > sum) return -1

        val rest = sum - x
        if (rest == 0) return nums.size

        var maxCount = 0
        var value = 0
        for (i in nums.indices) {
            value += nums[i]

            maxCount = if (rest - value == 0) {
                // + 1 하는 이유는 count 라서
                max(maxCount, i + 1)
            } else {
                // map 에 저장해둔 position
                val diff = map[value - rest] ?: continue
                max(maxCount, i - diff)
            }
        }

        if (maxCount == 0) return -1
        return nums.size - maxCount
    }
}