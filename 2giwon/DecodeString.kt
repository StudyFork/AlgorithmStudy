package leetcode.study

import java.util.*

class DecodeString {
    fun decodeString(s: String): String {
        var result = ""
        var count = ""
        val stack = Stack<Int>()
        val indexStack = Stack<Int>()

        var i = 0
        while (i < s.length) {
            when {
                s[i] == '[' -> {
                    stack.push(count.toInt())
                    indexStack.push(i)
                    count = ""
                }
                s[i] == ']' -> {
                    if (stack[stack.lastIndex] <= 1) {
                        stack.pop()
                        indexStack.pop()
                    } else {
                        stack[stack.lastIndex]--
                        i = indexStack.peek()
                    }
                }
                Character.isDigit(s[i]) -> {
                    count += s[i]
                }
                else -> {
                    result += s[i]
                }
            }
            i++
        }

        return result
    }
}