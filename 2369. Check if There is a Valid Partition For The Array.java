class Solution {
    public boolean validPartition(int[] nums) {
        return solve(nums, 0, new Boolean[nums.length]);
    }

    public boolean solve(int[] nums, int i, Boolean[] dp) {
        if (i == nums.length)
            return true;

        if (dp[i] != null)
            return dp[i]; 

        boolean result = false;

        // Check if the next two elements are the same
        if ((i + 1) < nums.length && (nums[i] == nums[i + 1]))
            result = result || solve(nums, i + 2, dp);

        // Check if the next three elements are the same
        if ((i + 2) < nums.length && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
            result = result || solve(nums, i + 3, dp);

        // Check if the next three elements form a consecutive sequence
        if ((i + 2) < nums.length && ((nums[i] + 1) == nums[i + 1]) && ((nums[i] + 2) == nums[i + 2]))
            result = result || solve(nums, i + 3, dp);

        return dp[i] = result;
    }
}
