fun solution(N: Int, M: Int): Int = N / gcd(N, M)

fun gcd(a: Int, b: Int): Int {
    val min = Math.min(a, b)
    val max = Math.max(a, b)

    return if (min == 0) max else gcd(min, max % min)
}
