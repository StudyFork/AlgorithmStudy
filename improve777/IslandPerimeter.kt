class IslandPerimeter {
    private val dx = intArrayOf(0, 0, -1, 1)
    private val dy = intArrayOf(-1, 1, 0, 0)

    fun islandPerimeter(grid: Array<IntArray>): Int {
        val tx = grid.size
        val ty = grid[0].size
        val visited = Array(tx) { BooleanArray(ty) }
        var count = 0

        for (i in 0 until tx) {
            for (j in 0 until ty) {
                count += dfs(grid, visited, i, j)
            }
        }

        return count
    }

    private fun dfs(
        grid: Array<IntArray>,
        visited: Array<BooleanArray>,
        x: Int,
        y: Int
    ): Int {
        val tx = grid.size - 1
        val ty = grid[0].size - 1

        if (grid[x][y] == 0) return 0
        if (visited[x][y]) return 0

        visited[x][y] = true

        var count = 0

        for (i in 0..3) {
            val mx = x + dx[i]
            val my = y + dy[i]

            if (mx !in 0..tx || my !in 0..ty) {
                count += 1
                continue
            }

            count += if (grid[mx][my] == 1) dfs(grid, visited, mx, my) else 1
        }

        return count
    }
}
