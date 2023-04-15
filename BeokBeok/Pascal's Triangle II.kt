class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        return makeRow(mutableListOf(), 0, rowIndex)
    }

    private fun makeRow(list: List<Int>, startIndex: Int, lastIndex: Int): List<Int> {
        if (startIndex > lastIndex) return list

        return when (startIndex) {
            0, 1 -> makeRow(list.plus(1), startIndex + 1, lastIndex)
            else -> {
                val sumList = list.windowed(2, 1, false)
                    .map(List<Int>::sum)
                makeRow(
                    mutableListOf<Int>().apply {
                        add(1)
                        addAll(sumList)
                        add(1)
                    },
                    startIndex + 1,
                    lastIndex
                )
            }
        }
    }
}
