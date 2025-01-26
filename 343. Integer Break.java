class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (n == 2)
            return 1;
        if (dp[n] != 0)
            return dp[n];
        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            int prod = i * Math.max(n - i, helper(n - i, dp));
            maxProduct = Math.max(maxProduct, prod);
        }
        dp[n] = maxProduct;
        return maxProduct;
    }
}
