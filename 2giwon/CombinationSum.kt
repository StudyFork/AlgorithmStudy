import java.util.*

class CombinationSum {
    private var target = 0
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        this.target = target
        return reqCal(candidates, 0, 0, Stack(), mutableListOf())
    }

    private fun reqCal(candidates: IntArray, i: Int, acc: Int, stack: Stack<Int>, answer: MutableList<List<Int>>): List<List<Int>> {
        var index = i
        while (index <= candidates.lastIndex) {
            if (acc == target) {
                answer.add(stack.toList())
                break
            }

            if (acc > target) {
                break
            }

            if (index > candidates.lastIndex) {
                break
            }

            val candidate: Int = candidates[index]
            stack.push(candidate)
            reqCal(candidates, index, acc + candidate, stack, answer)
            index++
        }

        if (!stack.empty()) stack.pop()
        return answer
    }
}