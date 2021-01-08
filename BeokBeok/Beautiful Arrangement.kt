class Solution {
    var count = 0
    
    fun countArrangement(n: Int): Int {
        backtracking(n, 1, IntArray(size = n + 1))
        return count
    }

    fun backtracking(n: Int, current: Int, visit: IntArray) {
        if (current > n) {
            count++
            return
        }

        for (i in 1..n) {
            val compareOne = current.rem(i) == 0
            val compareTwo = i.rem(current) == 0
            if (visit[i] == 0 && (compareOne || compareTwo)) {
                visit[i] = 1
                backtracking(n, current + 1, visit)
                visit[i] = 0
            }
        }
    }
}
