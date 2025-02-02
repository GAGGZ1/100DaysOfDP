class Solution {
    private int n;
    private int[][] dp;

    private int solve(String s, int currIndex, int prevVal) {
        if (currIndex >= n) {
            return 0;
        }

        if (dp[currIndex][prevVal] != -1) {
            return dp[currIndex][prevVal];
        }

        int flip = Integer.MAX_VALUE;
        int noFlip = Integer.MAX_VALUE;

        if (s.charAt(currIndex) == '0') {
            if (prevVal == 1) {
                flip = 1 + solve(s, currIndex + 1, 1);
            } else {
                flip = 1 + solve(s, currIndex + 1, 1);
                noFlip = solve(s, currIndex + 1, 0);
            }
        } else { // s.charAt(currIndex) == '1'
            if (prevVal == 1) {
                noFlip = solve(s, currIndex + 1, 1);
            } else {
                flip = 1 + solve(s, currIndex + 1, 0);
                noFlip = solve(s, currIndex + 1, 1);
            }
        }

        return dp[currIndex][prevVal] = Math.min(flip, noFlip);
    }

    public int minFlipsMonoIncr(String s) {
        n = s.length();
        dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s, 0, 0);
    }
}
