import kotlin.math.abs

private fun solution(A: IntArray): Int {
    var beforeP = 0
    var afterP = A.sum()
    var min = Int.MAX_VALUE

    for (i in 0 until A.size - 1) {
        beforeP += A[i]
        afterP -= A[i]
        val n = abs(beforeP - afterP)
        if (min > n) {
            min = n
        }
    }
    return min
}
