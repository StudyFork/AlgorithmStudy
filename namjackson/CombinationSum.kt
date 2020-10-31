class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()
        search(candidates.sortedArrayDescending(), target, intArrayOf(), resultList)
        return resultList.distinct()
    }

    private fun search(
            candidates: IntArray,
            target: Int,
            sumArray: IntArray,
            resultList: MutableList<List<Int>>
    ) {
        val sum = sumArray.sum()
        candidates.forEach { num ->
            val gap = target - (sum + num)
            when {
                (gap == 0) -> {
                    val list = sumArray.toMutableList().also { it.add(num) }
                    resultList.add(list.sorted())
                }
                (gap > 0) -> {
                    val list = sumArray.toMutableList().also { it.add(num) }
                    search(candidates, target, list.toIntArray(), resultList)
                }
            }
        }
    }
}