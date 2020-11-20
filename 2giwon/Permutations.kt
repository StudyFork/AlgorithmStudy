class Permutations {
    private var max: Int = 0
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = mutableListOf()
        val mutableNums = nums.toMutableList()
        max = nums.size

        if (nums.size <= 1) result.add(mutableNums)
        else req(mutableNums, mutableListOf(), mutableSetOf(), 0, result)

        return result
    }

    private fun req(
            nums: MutableList<Int>,
            values: MutableList<Int>,
            visited: MutableSet<Int>,
            depth: Int,
            result: MutableList<MutableList<Int>>
    ) {
        if (nums.size <= 1) {
            values.add(nums[0])
            return
        }

        for (i: Int in nums.indices) {
            if (depth == 0 && visited.contains(nums[i])) continue
            val v = values.toMutableList()
            val nums2 = nums.toMutableList()

            v.add(nums2[i])
            if (depth == 0) visited.add(nums2[i])
            nums2.remove(nums2[i])
            req(nums2, v, visited, depth + 1, result)

            if (v.size == max) result.add(v)
        }
    }


}