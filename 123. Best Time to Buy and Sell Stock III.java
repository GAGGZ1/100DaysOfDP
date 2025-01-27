class Solution {
    private int[][][] mem;

    private int recursion(int[] prices, int pos, int t, boolean bought) {
        if (pos >= prices.length || t == 0) // Out of bounds case
            return 0;

        // Convert `bought` (boolean) to integer index (0 or 1)
        int boughtIndex = bought ? 1 : 0;

        // Return if already calculated
        if (mem[boughtIndex][t][pos] != -1)
            return mem[boughtIndex][t][pos];

        // 3 choices for a position --> Buy/Sell/Skip
        int result = recursion(prices, pos + 1, t, bought); // SKIP
        if (bought) {
            result = Math.max(result, recursion(prices, pos + 1, t - 1, false) + prices[pos]); // SELL
        } else {
            result = Math.max(result, recursion(prices, pos + 1, t, true) - prices[pos]); // BUY
        }

        // Store the result in the memoization array
        mem[boughtIndex][t][pos] = result;
        return result;
    }

    public int maxProfit(int[] prices) {
        // Initialize the memoization array
        mem = new int[2][3][prices.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }

        // Start recursion from position 0, with 2 transactions remaining, and nothing
        // bought
        return recursion(prices, 0, 2, false);
    }
}
