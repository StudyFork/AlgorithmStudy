class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        if (n == 0) return emptyArray()

        val matrix = Array(n) {
            IntArray(n) { 0 }
        }

        var (rowStart, rowEnd) = 0 to n - 1
        var (colStart, colEnd) = 0 to n - 1
        var num = 1

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (i in colStart..colEnd) {
                matrix[rowStart][i] = num++
            }
            rowStart++

            for (i in rowStart..rowEnd) {
                matrix[i][colEnd] = num++
            }
            colEnd--

            for (i in colEnd downTo colStart) {
                if (rowStart > rowEnd) break
                matrix[rowEnd][i] = num++
            }
            rowEnd--

            for (i in rowEnd downTo rowStart) {
                if (colStart > colEnd) break
                matrix[i][colStart] = num++
            }
            colStart++
        }

        return matrix
    }
}
