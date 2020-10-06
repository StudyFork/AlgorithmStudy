class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        fun calculateSum(index: Int, target: Int, sum: Int): Int {
            if (index > numbers.lastIndex) {
                return if (target == sum) 1 else 0
            }
            val firstElement = numbers[index]
            val plusSum = calculateSum(index + 1, target, sum + firstElement)
            val minusSum = calculateSum(index + 1, target, sum - firstElement)
            return plusSum + minusSum
        }
        return calculateSum(0, target, 0)
    }
}
