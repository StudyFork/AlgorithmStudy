package wordpattern

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val sList = s.split(" ")
        val map = HashMap<Char, String>()

        if (sList.size != pattern.length) return false
        for (i in sList.indices) {
            if (map[pattern[i]] == null) {
                if (map.containsValue(sList[i])) return false
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