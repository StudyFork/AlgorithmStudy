fun solution(A: IntArray): Int {
    val total = A.sum()
    var (leftSum, rightSum) = A[0] to total - A[0]
    if (A.size == 1) return A[0]
    var result = Int.MAX_VALUE
    for (i in 1..A.lastIndex) {
        result = result.coerceAtMost(Math.abs(leftSum - rightSum))
        leftSum += A[i]
        rightSum -= A[i]
    }
    return result
}
