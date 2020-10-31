class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean = matrix
        .map(IntArray::toList)
        .flatten()
        .binarySearch(target) > -1
}
