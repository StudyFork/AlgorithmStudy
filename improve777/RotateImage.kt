class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        for (i in 0 until n) {
            for (j in 0 until i) {
                matrix[i][j] = matrix[j][i].also { matrix[j][i] = matrix[i][j] }
            }
        }

        for (i in 0 until n) {
            matrix[i].reverse()
        }
    }

    fun rotate2(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        for (layer in 0 until n / 2) {
            val start = layer
            val end = n - 1 - layer

            for (i in start until end) {
                // top
                val temp = matrix[start][i]
                // left -> top
                matrix[start][i] = matrix[n - 1 - i][start]
                // bottom -> left
                matrix[n - 1 - i][start] = matrix[end][n - 1 - i]
                // right -> bottom
                matrix[end][n - 1 - i] = matrix[i][end]
                // top -> right
                matrix[i][end] = temp
            }
        }
    }
}