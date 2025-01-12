class Solution {
    // Method to calculate the minimum number of steps required to make two strings equal
    public int minDistance(String word1, String word2) {
        // Use a helper function to find the length of the longest common subsequence (LCS)
        int length = helper(word1, word2);
        // Calculate the minimum distance using the formula:
        // Total deletions = word1.length() - LCS + word2.length() - LCS
        // This simplifies to: word1.length() + word2.length() - 2 * LCS
        return word1.length() + word2.length() - 2 * length;
    }

    // Helper function to compute the LCS of two strings using dynamic programming
    public int helper(String text1, String text2) {
        // Create a DP table with dimensions (length of text1 + 1) x (length of text2 + 1)
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        // Populate the DP table
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                // If either string is empty, LCS length is 0
                if (i == 0 || j == 0) {
                    continue;
                }
                // If the current characters match, extend the LCS by 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Otherwise, take the maximum LCS length by excluding one character at a time
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The final value at dp[text1.length()][text2.length()] is the LCS length
        return dp[text1.length()][text2.length()];
    }
}

class Solution {
    // Method to calculate the minimum number of steps required to make two strings equal
    public int minDistance(String text1, String text2) {
        // Create a DP table to store the minimum distance values
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Populate the DP table
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                // If one string is empty, the only option is to delete all characters of the other string
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j; // Total deletions = characters left in the non-empty string
                } 
                // If the current characters match, no operation is needed; take the previous value
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Otherwise, take the minimum steps from either deleting a character from text1 or text2
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The final value at dp[text1.length()][text2.length()] is the minimum distance
        return dp[text1.length()][text2.length()];
    }
}
