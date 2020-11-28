class RangeSumBST {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var result = 0
        root?.let {
            if (root.`val` in low..high) {
                result += root.`val`
            }
            result += rangeSumBST(root.left, low, high)
            result += rangeSumBST(root.right, low, high)
        }

        return result
    }
}