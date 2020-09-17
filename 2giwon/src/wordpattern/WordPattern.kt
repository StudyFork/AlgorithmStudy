package wordpattern

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val sList = s.split(" ")
        val map = mutableMapOf<Char, String>()

        if (sList.size != pattern.length) return false
        for (i in sList.indices) {
            if (map[pattern[i]] == null) {
                if (map.values.find { it == sList[i] }?.length ?: 0 > 1) return false

                map[pattern[i]] = sList[i]
            } else {
                if (map[pattern[i]] != sList[i]) {
                    return false
                }
            }

        }

        return true
    }
}