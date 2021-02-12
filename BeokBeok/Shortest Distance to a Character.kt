class Solution {
    fun shortestToChar(s: String, c: Char): IntArray {
        val result = IntArray(s.length)
        var position = -s.length
        s.forEachIndexed { index, value ->
            if (value == c) position = index
            result[index] = index - position
        }
        for (i in s.lastIndex downTo 0) {
            if (s[i] == c) position = i
            if (position - i < 0) continue
            result[i] = Math.min(result[i], position - i)
        }
        return result
    }
}
