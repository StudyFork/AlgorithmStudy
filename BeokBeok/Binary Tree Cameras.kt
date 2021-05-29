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
    
    var res = 0
    
    fun minCameraCover(root: TreeNode?): Int {
        return (if (dfs(root) < 1) 1 else 0) + res
    }
    
    fun dfs(root: TreeNode?): Int {
        if (root == null) return 2
        val (left, right) = dfs(root.left) to dfs(root.right)
        if (left == 0 || right == 0) {
            res++
            return 1
        }
        return if (left == 1 || right == 1) 2 else 0
    }
}
