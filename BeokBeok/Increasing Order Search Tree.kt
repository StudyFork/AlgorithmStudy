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
    fun increasingBST(root: TreeNode?): TreeNode? =
        build(root, null)
    
    fun build(target: TreeNode?, before: TreeNode?): TreeNode? {
        if (target == null) return before
        val result = build(target.left, target)
        target.left = null
        target.right = build(target.right, before)
        return result
    }
}
