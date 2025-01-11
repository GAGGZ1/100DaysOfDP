class Solution {
    private static final int MOD = 1000000007;
    private long[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new long[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    dp[i][j][k] = -1; 
                }
            }
        }
        return (int) countPaths(startRow, startColumn, maxMove, m, n);
    }

    private long countPaths(int row, int col, int remainingMoves, int m, int n) {
        // Base case: if out of bounds
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1; // One valid path found
        }
        // Base case: no remaining moves
        if (remainingMoves == 0) {
            return 0; // No valid path found
        }
        // Return cached result if already calculated
        if (dp[row][col][remainingMoves] != -1) {
            return dp[row][col][remainingMoves];
        }

        long paths = 0;
        // Explore all four directions
        paths += countPaths(row + 1, col, remainingMoves - 1, m, n); // Down
        paths += countPaths(row - 1, col, remainingMoves - 1, m, n); // Up
        paths += countPaths(row, col + 1, remainingMoves - 1, m, n); // Right
        paths += countPaths(row, col - 1, remainingMoves - 1, m, n); // Left

        // Store the result in dp array and return
        dp[row][col][remainingMoves] = paths % MOD;
        return dp[row][col][remainingMoves];
    }
}
