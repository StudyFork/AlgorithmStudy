class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        fun calculateSum(numbers: List<Int>, target: Int, sum: Int): Int {
            if (numbers.isEmpty()) {
                return if (target == sum) 1 else 0
            }
            val firstElement = numbers.first()
            val plusSum = calculateSum(numbers.drop(1), target, sum + firstElement)
            val minusSum = calculateSum(numbers.drop(1), target, sum - firstElement)
            return plusSum + minusSum
        }
        return calculateSum(numbers.toList(), target, 0)
    }
}
