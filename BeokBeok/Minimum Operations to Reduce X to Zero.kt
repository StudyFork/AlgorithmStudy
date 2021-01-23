class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val target = -x + nums.sum()
        if (target == 0) return nums.size

        val map = mutableMapOf<Int, Int>()
        map[0] = -1
        var (sum, res) = 0 to Int.MIN_VALUE

        for (i in nums.indices) {
            sum += nums[i]
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map[sum - target]!!)
            }
            map[sum] = i
        }
        return if (res == Int.MIN_VALUE) -1 else nums.size - res
    }
}
