fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    for (m in matrix) {
        if (m.binarySearch(target, 0) >= 0) return true
    }

    return false
}