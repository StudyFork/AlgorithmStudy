// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(N: Int, M: Int): Int = N / gcd(N, M)

tailrec fun gcd(a: Int, b: Int): Int {
    return when (val r = a % b) {
        0 -> b
        else -> gcd(b, r)
    }
}
