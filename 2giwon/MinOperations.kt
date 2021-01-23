import kotlin.math.min

class MinOperations {
    fun minOperations(nums: IntArray, x: Int): Int {
        var sum = 0
        var end = 0
        var start = nums.lastIndex
        var result = nums.size + 1

        while(sum < x && end < nums.size) {
            sum += nums[end++]
        }

        if (end == nums.size && sum != x) {
            return -1
        }

        if (end == nums.size && sum == x) {
            return nums.size
        }

        var count = end
        while (end > -1) {
            if (sum > x) {
                if (end == 0) break
                sum -= nums[(end--) - 1]
                count--
            } else if (sum < x) {
                sum += nums[start--]
                count++
            } else {
                result = min(result, count)
                if (end == 0) break
                sum -= nums[(end--) - 1]
                count--
            }
        }

        return if (result > nums.size) -1 else result

    }
}