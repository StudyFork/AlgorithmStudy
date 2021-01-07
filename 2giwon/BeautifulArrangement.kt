import java.util.*

class BeautifulArrangement {
    fun countArrangement(n: Int): Int {
        val arrangement = mutableListOf<Int>()
        for (i in 0 until n) {
            arrangement.add(i + 1)
        }

        return req(n, arrangement)
    }

    private fun req(n: Int, arrangement: MutableList<Int>): Int {
        if (n <= 0) return 1
        var result = 0
        for (i in 0 until n) {
            if (n % arrangement[i] == 0 || arrangement[i] % n == 0) {
                Collections.swap(arrangement, i, n - 1)
                result += req(n - 1, arrangement)
                Collections.swap(arrangement, i, n - 1)
            }
        }
        return result
    }

}