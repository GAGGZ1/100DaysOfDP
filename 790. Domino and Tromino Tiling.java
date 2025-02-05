class Solution {
    int[] dp = new int[1001];
    int m = 1000000007;

    public Solution() {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
    }

    public int numTilings(int n) {
        return solve(n);
    }

    public int solve(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = (2 * solve(n - 1) % m + solve(n - 3) % m) % m;
    }
}
