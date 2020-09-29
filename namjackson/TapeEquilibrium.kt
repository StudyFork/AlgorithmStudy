import kotlin.math.abs

fun solution(A: IntArray): Int {
    var minimum = Int.MAX_VALUE
    var firstPart = 0
    var secondPart = A.sum()
    (0 until A.lastIndex).forEach {
        firstPart += A[it]
        secondPart -= A[it]
        minimum = abs(firstPart - secondPart).takeIf { it < minimum } ?: minimum
    }
    return minimum
}