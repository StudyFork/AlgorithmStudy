class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {

        val map1 = HashMap<Char, Int>()
        val map2 = HashMap<Char, Int>()

        s.forEach {
            if (map1[it] != null) {
                map1[it] = (map1[it] ?: 0) + 1
            } else {
                map1[it] = 1
            }
        }

        t.forEach {
            if (map2[it] != null) {
                map2[it] = (map2[it] ?: 0) + 1
            } else {
                map2[it] = 1
            }
        }

        t.forEach {
            if (map1[it] == map2[it]) {
                map1.remove(it)
                map2.remove(it)
            }
        }
        return map1.size == 0 && map2.size == 0
    }
}