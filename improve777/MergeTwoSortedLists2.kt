/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        val acc = ListNode(0)
        merge(acc, list1, list2)
        return acc.next
    }

    private tailrec fun merge(acc: ListNode?, list1: ListNode?, list2: ListNode?) {
        if (list1 == null && list2 == null) return

        when {
            list1 != null && list2 != null -> {
                if (list1.`val` < list2.`val`) {
                    acc?.next = list1
                    merge(acc?.next, list1.next, list2)
                } else {
                    acc?.next = list2
                    merge(acc?.next, list1, list2.next)
                }
            }
            else -> {
                acc?.next = list1 ?: list2
                merge(acc?.next, null, null)
            }
        }
    }
}