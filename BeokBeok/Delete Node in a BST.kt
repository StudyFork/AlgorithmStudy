/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        when {
            root == null -> return root
            root.`val` > key -> root.left = deleteNode(root.left, key)
            root.`val` < key -> root.right = deleteNode(root.right, key)
            else -> {
                when {
                    root.left == null -> return root.right
                    root.right == null -> return root.left
                    else -> {
                        var minTarget = root.right
                        while (minTarget?.left != null) {
                            minTarget = minTarget.left
                        }
                        root.`val` = minTarget?.`val` ?: 0
                        root.right = deleteNode(root.right, root.`val`)
                    }
                }
            }
        }
        return root
    }
}
