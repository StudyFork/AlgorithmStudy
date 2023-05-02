import kotlin.math.abs

class BinaryTreeTilt {

    private var tilt = 0

    fun findTilt(root: TreeNode?): Int {
        sum(root)
        return tilt
    }

    private fun sum(node: TreeNode?): Int {
        if (node == null) return 0
        val left = sum(node.left)
        val right = sum(node.right)
        tilt += abs(left - right)
        return left + right + node.`val`
    }
}
