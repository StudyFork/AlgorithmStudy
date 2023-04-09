class FindTheTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n == 1) return 1
        if (trust.isEmpty()) return -1

        val outs = IntArray(n + 1)
        val ins = IntArray(n + 1)

        trust.forEach { (src, dst) ->
            outs[src]++
            ins[dst]++
        }

        for (i in 1..n) {
            if (outs[i] == 0 && ins[i] == n - 1) {
                return i
            }
        }

        return -1
    }
}
