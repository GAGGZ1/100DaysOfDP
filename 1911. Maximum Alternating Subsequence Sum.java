class Solution {
    private int n;
    private long[][] memo;

    private long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n) {
            return 0;
        }
        if (memo[idx][isEven ? 1 : 0] != -1) {
            return memo[idx][isEven ? 1 : 0];
        }

        // Option 1: Skip the current element
        long skip = solve(idx + 1, nums, isEven);

        // Option 2: Take the current element
        long val = nums[idx];
        if (!isEven) {
            val = -val;
        }
        long take = solve(idx + 1, nums, !isEven) + val;

        // Store and return the maximum of the two options
        return memo[idx][isEven ? 1 : 0] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return solve(0, nums, true);
    }
}
