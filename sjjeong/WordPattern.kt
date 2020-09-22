class Solution {

    fun wordPattern(pattern: String, s: String): Boolean {
        var remainText = s
        val patternMap = mutableMapOf<Char, String>()
        pattern.forEach {
            if (remainText.isEmpty()) {
                return false
            }
            val index = remainText.indexOf(' ')
            val str = if (index == -1) remainText else remainText.substring(0, index)

            val value = patternMap[it]
            if (value == null && !patternMap.values.contains(str)) {
                patternMap[it] = str
            } else {
                if (value != str) {
                    return false
                }
            }
            remainText = if (index == -1) "" else remainText.substring(index + 1, remainText.length)
        }
        if (remainText.isNotEmpty()) {
            return false
        }
        return true
    }
}