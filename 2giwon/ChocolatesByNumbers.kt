class ChocolatesByNumbers {
    fun solution(N: Int, M: Int): Int {
        tailrec fun solution(a: Int, b: Int): Int {
            if (b == 0) return N / a
            return solution(b, a % b)
        }

        return solution(N, M)
    }
}