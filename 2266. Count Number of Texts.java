class Solution {
    public int countTexts(String s) {
        int n = s.length();
        long dp[] = new long[n + 1]; // DP array to store combinations
        dp[0] = 1; // Base case: 1 way to interpret an empty string

        int mod = 1000000007;

        // Iterate through the string
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);

            // Include current character
            dp[i] = dp[i - 1];

            // Check if last 2 characters are the same
            if (i >= 2 && s.charAt(i - 2) == ch) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }

            // Check if last 3 characters are the same
            if (i >= 3 && s.charAt(i - 3) == ch) {
                dp[i] = (dp[i] + dp[i - 3]) % mod;
            }

            // Check if last 4 characters are the same for '7' or '9'
            if ((ch == '7' || ch == '9') && i >= 4 && s.charAt(i - 4) == ch) {
                dp[i] = (dp[i] + dp[i - 4]) % mod;
            }
        }

        // Return result modulo mod
        return (int) dp[n];
    }
}
