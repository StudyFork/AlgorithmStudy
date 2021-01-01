class SwapPairs {
    private val list = mutableListOf<Int>()

    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.v == null) return head
        req(head)

        for (i in list.indices) {
            if (i % 2 > 0) {
                val temp = list[i - 1]
                list[i - 1] = list[i]
                list[i] = temp
            }
        }

        return reqCreate(0, head)
    }

    private fun reqCreate(index: Int, head: ListNode?): ListNode? {
        if (index > list.lastIndex) {
            return null
        }

        val ret = ListNode(list[index])
        ret.next = reqCreate(index + 1, head?.next)
        return ret
    }

    private fun req(current: ListNode?) {
        if (current == null) return
        list.add(current.v ?: return)
        req(current.next)
    }
}