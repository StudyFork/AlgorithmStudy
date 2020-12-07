class Solution {
    fun decodeString(s: String): String {
        var result = ""
        var index = 0
        val (strStack, countStack) = Stack<String>() to Stack<Int>()

        while (index < s.length) {
            when {
                Character.isDigit(s[index]) -> {
                    var count = 0
                    while (Character.isDigit(s[index])) {
                        count = count * 10 + (s[index] - '0')
                        index++
                    }
                    countStack.push(count)
                }
                s[index] == '[' -> {
                    strStack.push(result)
                    result = ""
                    index++
                }
                s[index] == ']' -> {
                    var temp = strStack.pop()
                    repeat(countStack.pop()) {
                        temp += result
                    }
                    result = temp
                    index++
                }
                else -> {
                    result += s[index++]
                }
            }
        }

        return result
    }
}
