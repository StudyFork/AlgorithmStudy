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

class RecoverTree {
    private var prev: TreeNode? = null
    private var first: TreeNode? = null
    private var second: TreeNode? = null

    fun recoverTree(root: TreeNode?) {

        inOrder(root)

        val t = requireNotNull(first).`val`
        first?.`val` = requireNotNull(second).`val`
        second?.`val` = t
    }

    private fun inOrder(root: TreeNode?) {
        if (root == null) return

        inOrder(root.left)

        prev?.let { prev ->
            if (prev.`val` > root.`val`) {
                if (first == null) first = prev
                second = root
            }
        }

        prev = root
        inOrder(root.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}