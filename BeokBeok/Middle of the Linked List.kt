class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        return makeMiddle(head, head)
    }
    fun makeMiddle(slow: ListNode?, fast: ListNode?): ListNode? {
        return when {
            fast == null -> slow
            fast.next == null -> slow
            else -> makeMiddle(slow?.next, fast.next.next)
        }
    }
}
