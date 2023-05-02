class Solution {
    var result = 0

    fun findTilt(root: TreeNode?): Int {
        calculateTilt(root)
        return result
    }

    fun calculateTilt(root: TreeNode?): Int {
        return when {
            root == null -> 0
            else -> {
                val left = calculateTilt(root.left)
                val right = calculateTilt(root.right)
                result += Math.abs(left - right)

                left + right + root.`val`
            }
        }
    }
}
