class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        if (nums.size == 1) return listOf(nums.toList())

        val result = mutableSetOf<List<Int>>()
        val list = nums.toMutableList()

        fun _permuteUnique(loop: MutableList<Int>, acc: MutableList<Int>) {
            if (loop.isEmpty()) result.add(acc)

            for (i in loop) {
                val copy = loop.toMutableList()
                copy.remove(i)
                val added = acc.toMutableList().apply { add(i) }
                _permuteUnique(copy, added)
            }
            if (loop.isEmpty()) result.add(acc)
        }

        _permuteUnique(list, mutableListOf())

        return result.toList()
    }
}
