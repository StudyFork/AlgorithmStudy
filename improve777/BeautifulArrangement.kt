class BeautifulArrangement {
    var count = 0

    fun countArrangement(n: Int): Int {
        val array = IntArray(n)
        for (i in 0 until n) array[i] = i + 1
        permute(array, 0)
        return count
    }

    fun permute(array: IntArray, start: Int) {
        if (start == array.size) {
            count++
            return
        }
        for (i in start until array.size) {
            swap(array, i, start)
            val firstCondition = array[start] % (start + 1) == 0
            val secondCondition = (start + 1) % array[start] == 0
            if (firstCondition || secondCondition) permute(array, start + 1)
            swap(array, i, start)
        }
    }

    fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}