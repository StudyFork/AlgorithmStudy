class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        return search(numbers, target, 0, 0)
    }

    private fun search(numbers: IntArray, target: Int, index: Int, sum: Int): Int {
        return when {
            index < numbers.size -> {
                val plusCount = search(numbers, target, index + 1, sum + numbers[index])
                val minusCount = search(numbers, target, index + 1, sum - numbers[index])
                plusCount + minusCount
            }
            else -> if (sum == target) 1 else 0
        }
    }
}
