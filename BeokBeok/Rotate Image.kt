class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (col in matrix.first().indices) {
            for (row in col + 1 until matrix.size) {
                val temp = matrix[row][col]
                matrix[row][col] = matrix[col][row]
                matrix[col][row] = temp
            }
        }
        matrix.forEach(IntArray::reverse)
    }
}
