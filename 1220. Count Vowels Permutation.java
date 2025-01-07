class Solution {
    public int countVowelPermutation(int n) {
        // Modulo to prevent overflow
        int mod = 1_000_000_007;

        // Indices for vowels: a, e, i, o, u
        int a = 0, e = 1, i = 2, o = 3, u = 4;

        // DP table: dp[j][c] where j = string length, c = vowel index
        long[][] dp = new long[n + 1][5];

        // Base case: for strings of length 1, each vowel can occur once
        dp[1][a] = 1;
        dp[1][e] = 1;
        dp[1][i] = 1;
        dp[1][o] = 1;
        dp[1][u] = 1;

        // Fill the DP table for lengths 2 to n
        for (int j = 2; j <= n; j++) {
            dp[j][a] = ((dp[j - 1][e] + dp[j - 1][i]) % mod + dp[j - 1][u]) % mod;
            dp[j][e] = (dp[j - 1][a] + dp[j - 1][i]) % mod;
            dp[j][i] = (dp[j - 1][e] + dp[j - 1][o]) % mod;
            dp[j][o] = dp[j - 1][i] % mod;
            dp[j][u] = (dp[j - 1][i] + dp[j - 1][o]) % mod;
        }

        // Sum up all possibilities for strings of length n
        long result = 0;
        for (int c = 0; c < 5; c++) {
            result = (result + dp[n][c]) % mod;
        }

        return (int) result;
    }
}
