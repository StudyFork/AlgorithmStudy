class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        if (pushed.size != popped.size) return false
        val stack = Stack<Int>()
        var (pushedIndex, poppedIndex) = 0 to 0
        while (poppedIndex < popped.size) {
            if (pushedIndex < pushed.size) {
                stack.push(pushed[pushedIndex])
                pushedIndex++
            } else if (pushedIndex == pushed.size) {
                return false
            }
            while (stack.isNotEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop()
                poppedIndex++
            }
        }
        return stack.isEmpty()     
    }
}
