class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        fun calculateSum(index: Int, target: Int, sum: Int): Int {
            if (index > numbers.lastIndex) {
                return if (target == sum) 1 else 0
            }
            return calculateSum(index + 1, target, sum + numbers[index]) + 
                calculateSum(index + 1, target, sum - numbers[index])
        }
        return calculateSum(0, target, 0)
    }
}
