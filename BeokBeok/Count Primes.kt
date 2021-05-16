class Solution {
    fun countPrimes(n: Int): Int {
        if (n == 0 || n == 1) return 0

        val notPrime = Array(n) { false }
        var count = 0
        (2 until n)
            .forEach {
                if (notPrime[it]) return@forEach
                count++
                var index = 2
                while (index * it < n) {
                    notPrime[index*it] = true
                    index++
                }
            }
        return count
    }
}
