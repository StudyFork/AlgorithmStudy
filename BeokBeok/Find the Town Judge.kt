class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val counts = Array(n + 1) { 0 }
        for (item in trust) {
            counts[item[0]]--
            counts[item[1]]++
        }
        for (i in 1..n) {
            if (counts[i] == n - 1) return i
        }
        return -1
    }
}
