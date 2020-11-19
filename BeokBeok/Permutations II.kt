class Solution {
    val result = mutableListOf<List<Int>>()
    val visit = mutableMapOf<Int, Boolean>()
    val temp = mutableListOf<Int>()
    
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        if (nums.size == 1) return listOf(nums.toList())
        doDFS(nums.sorted())
        return result.distinct()
    }
    
    fun doDFS(nums: List<Int>) {
        if (nums.size == temp.size) {
            result.add(temp.toList())
            return
        }
        for (i in nums.indices) {
            if (!visit.containsKey(i)) visit.computeIfAbsent(i) { false }
            if (visit[i] == true) continue
            visit[i] = true
            temp.add(nums[i])
            doDFS(nums)
            visit[i] = false
            temp.removeAt(temp.lastIndex)
        }
    }
}
