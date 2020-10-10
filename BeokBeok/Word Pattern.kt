class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val (patternToCharArr, sToSplitList) =  pattern.toCharArray() to s.split(" ")
        if (patternToCharArr.size != sToSplitList.size) return false
        val patternToSMap = mutableMapOf<Char, String>()
        patternToCharArr.forEachIndexed { index, char ->
            patternToSMap.computeIfAbsent(char) { sToSplitList[index] }
            if (!patternToSMap.containsKey(char)) return@forEachIndexed
            if (patternToSMap[char] != sToSplitList[index]) return false
        }
        return patternToCharArr.distinct().size == patternToSMap.values.distinct().size
    }
}
