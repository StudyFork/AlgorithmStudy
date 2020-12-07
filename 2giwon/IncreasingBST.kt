class IncreasingBST {
    private var current: TreeNode? = null
    fun increasingBST(root: TreeNode?): TreeNode? {
        val answer = TreeNode(0)
        current = answer
        inOrder(root)
        return answer.right
    }

    private fun inOrder(node: TreeNode?) {
        if (node == null) return
        inOrder(node.left)
        node.left = null
        current?.right = node
        current = node
        inOrder(node.right)
    }
}