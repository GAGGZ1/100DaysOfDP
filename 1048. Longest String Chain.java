class Solution {
    private int[][] memo;
    private int n;

    private boolean isPredecessor(String prev, String curr) {
        int m = prev.length();
        int len = curr.length();

        if (m >= len || len - m != 1) {
            return false;
        }

        int i = 0, j = 0;
        while (i < m && j < len) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    private int longestIncreasingSubsequence(String[] words, int prevIdx, int currIdx) {
        if (currIdx == n) {
            return 0;
        }

        if (prevIdx != -1 && memo[prevIdx][currIdx] != -1) {
            return memo[prevIdx][currIdx];
        }

        int taken = 0;
        if (prevIdx == -1 || isPredecessor(words[prevIdx], words[currIdx])) {
            taken = 1 + longestIncreasingSubsequence(words, currIdx, currIdx + 1);
        }

        int notTaken = longestIncreasingSubsequence(words, prevIdx, currIdx + 1);

        if (prevIdx != -1) {
            memo[prevIdx][currIdx] = Math.max(taken, notTaken);
        }

        return Math.max(taken, notTaken);
    }

    public int longestStrChain(String[] words) {
        n = words.length;
        memo = new int[n + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        return longestIncreasingSubsequence(words, -1, 0);
    }
}
