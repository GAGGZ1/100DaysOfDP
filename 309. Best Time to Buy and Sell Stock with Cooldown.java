class Solution {

    private HashMap<String, Integer> dp;

    public int maxProfit(int[] prices) {
        dp = new HashMap<>();
        return dfs(prices, 0, true); // Start with the first day, and we are allowed to buy
    }

    private int dfs(int[] prices, int i, boolean buying) {
        // Base case: If we have processed all prices, return 0 profit
        if (i >= prices.length) {
            return 0;
        }

        // Check if this state has already been computed
        String key = i + "," + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // Cooldown case: Just move to the next day without doing anything
        int cooldown = dfs(prices, i + 1, buying);

        int result;
        if (buying) {
            // Option to buy: We buy on day i, and the next step will be to sell
            int buy = dfs(prices, i + 1, false) - prices[i];
            result = Math.max(buy, cooldown); // Maximize between buying or cooling down
        } else {
            // Option to sell: We sell on day i and skip the next day for cooldown
            int sell = dfs(prices, i + 2, true) + prices[i];
            result = Math.max(sell, cooldown); // Maximize between selling or cooling down
        }

        // Save the result for the current state
        dp.put(key, result);
        return result;
    }
}
