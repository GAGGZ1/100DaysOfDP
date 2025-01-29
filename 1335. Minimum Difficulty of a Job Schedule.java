class Solution {
    private int[][] dp;

    public int minDifficulty(int[] jd, int d) {
        if (jd.length < d) {
            return -1;
        }
        dp = new int[jd.length][d + 1]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(jd, jd.length, d, 0);
    }

    private int solve(int[] jd, int n, int d, int i) {
        if (d == 1) {
            int max = jd[i];
            for (int j = i; j < n; j++) {
                max = Math.max(jd[j], max);
            }
            return max;
        }

        if (dp[i][d] != -1) {
            return dp[i][d];
        }

        int max = jd[i];
        int fres = Integer.MAX_VALUE;

        for (int j = i; j <= n - d; j++) {
            max = Math.max(max, jd[j]);
            int res = max + solve(jd, n, d - 1, j + 1);
            fres = Math.min(res, fres);
        }

        return dp[i][d] = fres;
    }
}
