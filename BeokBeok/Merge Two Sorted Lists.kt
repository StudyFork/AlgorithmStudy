/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1

        val result = ListNode(0)
        if (l1.`val` > l2.`val`) {
            result.`val` = l2.`val`
            result.next = ListNode(0)
            merge(l1, l2.next, result.next)
        } else {
            result.`val` = l1.`val`
            result.next = ListNode(0)
            merge(l1.next, l2, result.next)
        }
        return result
    }
    
    fun merge(l1: ListNode?, l2: ListNode?, result: ListNode?) {
        if (l1 == null && l2 == null) return

        when {
            l1 == null && l2 != null -> {
                result?.`val` = l2.`val`
                if (l2.next != null) result?.next = ListNode(0)
                merge(l1, l2.next, result?.next)
            }
            l1 != null && l2 == null -> {
                result?.`val` = l1.`val`
                if (l1.next != null) result?.next = ListNode(0)
                merge(l1.next, l2, result?.next)
            }
            l1?.`val` ?: 0 > l2?.`val` ?: 0 -> {
                result?.`val` = l2?.`val` ?: 0
                result?.next = ListNode(0)
                merge(l1, l2?.next, result?.next)
            }
            else -> {
                result?.`val` = l1?.`val` ?: 0
                result?.next = ListNode(0)
                merge(l1?.next, l2, result?.next)
            }
        }
    }
}
