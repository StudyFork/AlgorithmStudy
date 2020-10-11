class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        val diff = (numbers.sum() - target) / 2
        return find(numbers, diff, 0, numbers.size)
    }

    fun find(numbers: IntArray, diff: Int, index: Int, size: Int): Int {
        var answer = 0
        for (i in index until size) {
            val number = numbers[i]
            if (number == diff) {
                answer++
            } else if (number < diff) {
                answer += find(numbers, diff - number, i + 1, size)
            }
        }
        return answer
    }
}