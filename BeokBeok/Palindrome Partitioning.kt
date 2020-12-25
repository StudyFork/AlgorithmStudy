class Solution {
    val result = mutableListOf<List<String>>()
    val current = mutableListOf<String>()
    
    fun partition(s: String): List<List<String>> {
        backTrack(s, 0)
        return result.toList()
    }
    
    fun backTrack(s: String, l: Int) {
        if (current.size > 0 && l >= s.length) {
            result.add(current.toList())
        }
        for (i in l..s.lastIndex) {
            if (isPalindrome(s, l, i)) {
                if (l == i) {
                    current.add(s[i].toString())
                } else {
                    current.add(s.substring(l, i + 1))
                }
                backTrack(s, i + 1)
                current.removeAt(current.lastIndex)
            }
        }
    }
    
    fun isPalindrome(s: String, l: Int, i: Int): Boolean {
        var (length, index) = l to i
        if (length == index) return true
        while (length < index) {
            if (s[length] != s[index]) return false
            length++
            index--
        }
        return true
    }
}
