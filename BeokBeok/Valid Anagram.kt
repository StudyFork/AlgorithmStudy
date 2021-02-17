class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        return s
            .toCharArray()
            .sorted()
            .joinToString("") == t
                .toCharArray()
                .sorted()
                .joinToString("")
    }
}
