// Solution class for solving the Max Uncrossed Lines problem
class Solution {
    // Recursive approach without memoization
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // Start the helper function with the first indices of both arrays
        return helper(nums1, nums2, 0, 0);
    }

    private int helper(int[] nums1, int[] nums2, int i, int j) {
        // Base case: If either array is fully traversed, return 0 (no more lines can be drawn)
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        int include = 0;
        // If the current elements match, include this line and move to the next elements in both arrays
        if (nums1[i] == nums2[j]) {
            include = 1 + helper(nums1, nums2, i + 1, j + 1);
        }

        // Option 1: Skip the current element in nums1
        int skipNums1 = helper(nums1, nums2, i + 1, j);
        // Option 2: Skip the current element in nums2
        int skipNums2 = helper(nums1, nums2, i, j + 1);

        // Return the maximum of including the line or skipping an element
        return Math.max(Math.max(skipNums1, skipNums2), include);
    }
}

// Solution class for the memoized recursive approach
class Solution {
    int dp[][]; // Memoization table to store intermediate results

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // Initialize the memoization table with -1 (indicating uncomputed values)
        dp = new int[nums1.length + 1][nums2.length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        // Start the helper function with the first indices of both arrays
        return helper(nums1, nums2, 0, 0);
    }

    private int helper(int[] nums1, int[] nums2, int i, int j) {
        // Base case: If either array is fully traversed, return 0
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        // If this state has already been computed, return the stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int include = 0;
        // If the current elements match, include this line and move to the next elements
        if (nums1[i] == nums2[j]) {
            include = 1 + helper(nums1, nums2, i + 1, j + 1);
        }

        // Option 1: Skip the current element in nums1
        int skipNums1 = helper(nums1, nums2, i + 1, j);
        // Option 2: Skip the current element in nums2
        int skipNums2 = helper(nums1, nums2, i, j + 1);

        // Compute and store the maximum result in the memoization table
        return dp[i][j] = Math.max(Math.max(skipNums1, skipNums2), include);
    }
}

// Solution class for the iterative DP approach
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length; // Length of nums1
        int n = nums2.length; // Length of nums2

        // DP table to store results for subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // If the current elements match, add 1 to the diagonal value
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    // Otherwise, take the maximum of skipping either element
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // Return the result stored at dp[0][0], which represents the full problem
        return dp[0][0];
    }
}
