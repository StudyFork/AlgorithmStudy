fun solution(A: IntArray): Int {
    var sum = A.sum() - A[0]
    var min = Int.MAX_VALUE
    A.reduce { acc, i ->
        val absoluteValue = (acc - sum).absoluteValue
        if (absoluteValue < min) {
            min = absoluteValue
        }
        sum -= i
        acc + i
    }
    return min
}