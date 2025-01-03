// Day 5
class Solution {
    int mod = 1000000007;
    long product = -1;

    public int maxProductPath(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return (int) (product % mod);
    }

    public int dfs(int[][] grid, int i, int j, long curr) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            product = Math.max(product, curr);
            return;
        }
        if (grid[i][j] == 0) {
            product = Math.max(product, 0);
            return;
        }
        if (i + 1 < grid.length)
            dfs(grid, i + 1, j, curr * grid[i + 1][j]);
        if (j + 1 < grid[0].length)
            dfs(grid, i, j + 1, curr * grid[i][j + 1]);
    }
}
