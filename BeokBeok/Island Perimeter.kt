class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var (island, adjacency) = 0 to 0
        grid.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, _ ->
                if (row[colIndex] == 1) {
                    island++
                    if (rowIndex + 1 < grid.size && grid[rowIndex + 1][colIndex] == 1) adjacency++
                    if (colIndex + 1 < row.size && row[colIndex + 1] == 1) adjacency++
                }
            }
        }
        return island * 4 - adjacency * 2
    }
}
