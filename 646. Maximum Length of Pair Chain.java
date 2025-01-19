class Solution {
    private int n;
    private int[][] t;

    private int lis(int[][] nums, int prevIdx, int currIdx) {
        if (currIdx == n) {
            return 0;
        }

        if (prevIdx != -1 && t[prevIdx][currIdx] != -1) {
            return t[prevIdx][currIdx];
        }

        int taken = 0;
        if (prevIdx == -1 || nums[currIdx][0] > nums[prevIdx][1]) {
            taken = 1 + lis(nums, currIdx, currIdx + 1);
        }

        int notTaken = lis(nums, prevIdx, currIdx + 1);

        if (prevIdx != -1) {
            t[prevIdx][currIdx] = Math.max(taken, notTaken);
        }

        return Math.max(taken, notTaken);
    }

    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        t = new int[n + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        return lis(pairs, -1, 0);
    }
}
