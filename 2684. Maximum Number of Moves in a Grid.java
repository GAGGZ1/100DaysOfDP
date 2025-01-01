class Solution {
    int[][] memo;

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxMoves = 0;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0));
        }

        return maxMoves;
    }

    private int dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        int maxMove = 0;
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        // Move up-right
        if (row - 1 >= 0 && col + 1 < n && grid[row - 1][col + 1] > grid[row][col]) {
            maxMove = Math.max(maxMove, 1 + dfs(grid, row - 1, col + 1));
        }

        // Move right
        if (col + 1 < n && grid[row][col + 1] > grid[row][col]) {
            maxMove = Math.max(maxMove, 1 + dfs(grid, row, col + 1));
        }

        // Move down-right
        if (row + 1 < m && col + 1 < n && grid[row + 1][col + 1] > grid[row][col]) {
            maxMove = Math.max(maxMove, 1 + dfs(grid, row + 1, col + 1));
        }

        return memo[row][col] = maxMove;
    }
}
