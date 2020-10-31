class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        matrix.forEach {
            if (it.isNotEmpty()) {
                if (target <= it[it.lastIndex]) {
                    return it.contains(target)
                }
            }
        }
        return false
    }
}
