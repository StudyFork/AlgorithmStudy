class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val (open, close) = '(' to ')'
        val result = s.toCharArray()
        val bracketIndexes = Stack<Int>()
        s.forEachIndexed { index, c ->
            when (c) {
                open -> bracketIndexes.push(index)
                close -> {
                    if (bracketIndexes.isNotEmpty()) bracketIndexes.pop()
                    else result[index] = '-'
                }
            }
        }
        while (bracketIndexes.isNotEmpty()) {
            result[bracketIndexes.pop()] = '-'
        }
        return result
            .joinToString("")
            .replace("-", "")
    }
}
