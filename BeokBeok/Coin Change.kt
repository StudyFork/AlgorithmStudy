class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = Array(amount + 1) { amount + 1 }.apply {
            set(0, 0)
        }
        for (i in 1..amount) {
            for (j in coins.indices) {
                if (coins[j] <= i) dp[i] = dp[i].coerceAtMost(dp[i - coins[j]] + 1)
            }
        }
        return if (dp[amount] > amount) -1 else dp[amount]
    }
}
