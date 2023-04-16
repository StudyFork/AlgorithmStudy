class PascalsTriangleii {
    fun getRow(rowIndex: Int): List<Int> {
        val triangle = mutableListOf(listOf(1), listOf(1, 1))

        if (rowIndex < 2) {
            return triangle[rowIndex]
        }

        for (row in 2..rowIndex) {
            val list = mutableListOf<Int>()

            val upperIndex = row - 1
            val upper = triangle[upperIndex]

            for (i in 0 until row + 1) {
                val upperPrevNum = upper.getOrNull(i - 1) ?: 0
                val upperNum = upper.getOrNull(i) ?: 0
                val num = upperPrevNum + upperNum
                list.add(num)
            }
            triangle.add(list)
        }

        return triangle[rowIndex]
    }
}
