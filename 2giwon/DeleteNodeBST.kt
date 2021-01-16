class DeleteNodeBST {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        if (key == 0) return root
        if (root.`val` == key) return merge(root.right, root.left)

        if (key < root.`val`) root.left = deleteNode(root.left, key)
        if (key > root.`val`) root.right = deleteNode(root.right, key)
        return root
    }

    private fun merge(root: TreeNode?, node: TreeNode?): TreeNode? {
        if (root == null) return node
        else if (node == null) return root

        if (node.`val` < root.`val`) root.left = merge(root.left, node)
        if (node.`val` > root.`val`) root.right = merge(root.right, node)
        return root
    }
}