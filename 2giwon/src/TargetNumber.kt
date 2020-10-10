class TargetNumber {
    private var target = 0
    fun solution(numbers: IntArray, target: Int): Int {
        this.target = target
        return reqCal(numbers, 0, 0, 0)
    }

    private fun reqCal(numbers: IntArray, i: Int, acc: Int, ans: Int): Int {
        if (acc == target && i == numbers.size) return ans + 1
        if (i >= numbers.size) return ans

        var current = acc + numbers[i]
        var answer = ans + reqCal(numbers, i + 1, current, ans)

        current = acc + (-numbers[i])
        answer += reqCal(numbers, i + 1, current, ans)

        return answer
    }
}