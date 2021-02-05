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
        var target: ListNode? = null
        
        val list = mutableListOf<Int>()
        
        target = l1
        while (target != null) {
            list.add(target.`val`)
            target = target.next
        }
        
        target = l2
        while (target != null) {
            list.add(target.`val`)
            target = target.next
        }
        
        if (list.isEmpty()) return null
        
        list.sort()
        
        val result = ListNode(list.removeAt(0))
        var last = result
    
        for (i in list) {
            val node = ListNode(i)
            last.next = node
            last = node
        }
        
        return result
    }
}