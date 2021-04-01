class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        
        val (up, down) = Array(nums.size) { 1 } to Array(nums.size) { 1 }
        for (i in 1..nums.lastIndex) {
            when {
                nums[i] > nums[i - 1] -> {
                    up[i] = down[i - 1] + 1
                    down[i] = down[i - 1]
                }
                nums[i] < nums[i - 1] -> {
                    down[i] = up[i - 1] + 1
                    up[i] = up[i - 1]
                }
                else -> {
                    up[i] = up[i - 1]
                    down[i] = down[i - 1]
                }
            }
        }
        return Math.max(up[nums.lastIndex], down[nums.lastIndex])
    }
}
