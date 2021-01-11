class DeleteNodeInaBST {

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (root.`val` > key) {
            root.left = deleteNode(root.left, key)
        }
        else if (root.`val` < key) {
            root.right = deleteNode(root.right, key)
        }
        else {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }

            val min = searchMin(root.right)
            if (min != null) {
                root.`val` = min.`val`
                root.right = deleteNode(root.right, min.`val`)
            }
        }
        return root
    }

    fun searchMin(node: TreeNode?): TreeNode? {
        if (node == null) return null
        return if (node.left == null) node
        else searchMin(node.left)
    }
}