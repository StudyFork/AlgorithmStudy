class Solution {
    fun removeDuplicates(s: String, k: Int): String {
        val (counts, sb) = Array(s.length) { 0 } to StringBuilder()
        s.forEach {
            sb.append(it)
            counts[sb.lastIndex] = 1 + if (sb.lastIndex > 0 && sb.last() == sb[sb.lastIndex - 1]) counts[sb.lastIndex - 1] else 0
            if (counts[sb.lastIndex] == k) sb.delete(sb.length - k, sb.length)
        }
        return sb.toString()
    }
}
