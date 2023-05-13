class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = nums[0]
        val sumList = mutableListOf<Int>().apply {
            add(nums[0])
        }   
        for (i in 1 until nums.size) {
            sumList.add(nums[i] + if (sumList[i - 1] > 0) sumList[i - 1] else 0)
            result = result.coerceAtLeast(sumList.last())
        }
        return result
    }
}
