import java.util.LinkedList

class AssignCookies {
    fun findContentsChildren(g: IntArray, s: IntArray): Int {
        if (s.isEmpty()) return 0

        val cookies = LinkedList(s.sortedDescending())
        var count = 0

        for (children in g.sortedDescending()) {
            val cookie = cookies.peek() ?: break
            if (children <= cookie) {
                count++
                cookies.pop()
            }
        }

        return count
    }
}