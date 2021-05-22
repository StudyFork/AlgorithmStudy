class Solution {
    fun longestStrChain(words: Array<String>): Int {
        val dp = mutableMapOf<String, Int>()
        var res = 0
        words
            .sortedBy { it.length }
            .forEach { word ->
                var best = 0
                repeat(word.length) {
                    val prev = word.substring(0, it) + word.substring(it + 1)
                    best = Math.max(best, dp.getOrDefault(prev, 0) + 1)
                }
                dp[word] = best
                res = Math.max(res, best)
            }
        return res
    }
}
