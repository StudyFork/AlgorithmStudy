class Palindrome {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        dfs(s, 0, mutableListOf(), result)
        return result
    }

    private fun dfs(s: String, index: Int, path: MutableList<String>, ret: MutableList<List<String>>) {
        if (index == s.length) {
            ret.add(path)
            return
        }

        for (i in index + 1..s.length) {
            if (isPalindrome(s.substring(index, i))) {
                val p = path.toMutableList()
                p.add(s.substring(index, i))
                dfs(s, i, p, ret)
            }
        }
    }

    private fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left++] != s[right--]) {
                return false
            }
        }

        return true
    }


}