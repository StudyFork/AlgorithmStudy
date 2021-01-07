class SpiralMatrix2 {
    private lateinit var matrix: Array<IntArray>
    private var number = 1

    fun generateMatrix(n: Int): Array<IntArray> {
        matrix = Array(n) { IntArray(n) { 0 } }

        val directions: Array<Pair<Int, Int>> = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var directionIndex = 0
        var col = 0
        var row = 0

        matrix[col][row] = number++

        while (true) {
            if (number > n * n) break
            while (true) {
                val direction = directions[directionIndex]
                if (row + direction.second !in 0 until n || col + direction.first !in 0 until n) break

                if (move(col + direction.first, row + direction.second)) {
                    col += direction.first
                    row += direction.second
                } else {
                    break
                }
            }

            directionIndex = if (directionIndex + 1 >= directions.size) 0 else directionIndex + 1
        }

        return matrix
    }

    private fun move(col: Int, row: Int): Boolean {
        return if (matrix[col][row] == 0) {
            matrix[col][row] = number++
            true
        } else {
            false
        }
    }
}