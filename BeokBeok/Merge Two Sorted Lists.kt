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
    tailrec fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return when {
            list1 == null -> list2
            list2 == null -> list1
            list1.`val` <= list2.`val` -> {
                list1.next = mergeTwoLists(list1.next, list2)
                list1
            }
            else -> {
                list2.next = mergeTwoLists(list1, list2.next)
                list2
            }
        }
    }
}
