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
    var swappedFirstNode: TreeNode? = null
    var swappedSecondNode: TreeNode? = null
    var prevNode: TreeNode = TreeNode(Int.MIN_VALUE)

    fun recoverTree(root: TreeNode?): Unit {
        if (root == null) return

        doDFS(root)

        val temp = swappedFirstNode?.`val` ?: Int.MIN_VALUE
        swappedFirstNode?.`val` = swappedSecondNode?.`val` ?: Int.MIN_VALUE
        swappedSecondNode?.`val` = temp
    }

    private fun doDFS(root: TreeNode?) {
        if (root == null) return

        doDFS(root.left)

        if (swappedFirstNode == null && prevNode.`val` > root.`val`) {
            swappedFirstNode = prevNode
        }

        if (swappedFirstNode != null && prevNode.`val` > root.`val`) {
            swappedSecondNode = root
        }
        prevNode = root

        doDFS(root.right)
    }
}
