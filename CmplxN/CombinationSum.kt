class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val sortedCandidates = candidates.sorted()
        val rtn = mutableListOf<List<Int>>()
        val temp = mutableListOf<Int>()
        fun dfs(sum: Int, idx: Int) {
            if (sum == target) {
                rtn.add(temp.map { it })
                return
            }
            for (i in idx..sortedCandidates.lastIndex) {
                val pick = sortedCandidates[i]
                if (sum + pick > target) return
                temp.add(pick)
                dfs(sum + pick, i)
                temp.removeAt(temp.lastIndex)
            }
        }
        dfs(0, 0)
        return rtn
    }
}
