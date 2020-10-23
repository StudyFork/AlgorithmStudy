class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()
        calculate(result, mutableListOf(), candidates, target, 0)
        return result
    }
    
    fun calculate(result: MutableList<List<Int>>, temp: MutableList<Int>, candidates: IntArray, target: Int, startIndex: Int) {
        when {
            target < 0 -> return
            target == 0 -> result.add(temp.toList())
            else -> {
                for (i in startIndex..candidates.lastIndex) {
                    temp.add(candidates[i])
                    calculate(result, temp, candidates, target - candidates[i], i)
                    temp.removeAt(temp.lastIndex)
                }
            }
        }
    }
}
