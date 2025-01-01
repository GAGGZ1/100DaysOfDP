class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];
        Integer[][] dp = new Integer[n][n];
        return countPalindromes(s, 0, n - 1, memo, dp);
    }

    private int countPalindromes(String s, int start, int end, Boolean[][] memo, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int count = isPalindrome(s, start, end, memo) ? 1 : 0;
        count += countPalindromes(s, start + 1, end, memo, dp);
        count += countPalindromes(s, start, end - 1, memo, dp);
        count -= countPalindromes(s, start + 1, end - 1, memo, dp);
        dp[start][end] = count;
        return count;
    }

    private boolean isPalindrome(String s, int start, int end, Boolean[][] memo) {
        if (start >= end) {
            return true;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        boolean result = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1, memo);
        memo[start][end] = result;
        return result;
    }
}
