class Solution {
    private static final int MOD = 1000000007;
    private int[] dp;

    private int countWays(int low, int high, int zero, int one, int pos) {
        if (pos > high) {
            return 0;
        }
        if (dp[pos] != -1) {
            return dp[pos];
        }

        int count = 0;
        if (pos >= low) {
            count = 1;
        }
        count = (count + countWays(low, high, zero, one, pos + zero)) % MOD;
        count = (count + countWays(low, high, zero, one, pos + one)) % MOD;

        return dp[pos] = count;
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return countWays(low, high, zero, one, 0);
    }
}
