class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int) = matrix.map { it.toList() }.flatten().binarySearch(target) >= 0
}
