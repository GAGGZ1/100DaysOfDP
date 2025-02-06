class Solution {
    private HashMap<String, Integer> dp;
    private int fee;

    public int maxProfit(int[] prices, int fee) {
        this.dp = new HashMap<>();
        this.fee = fee;
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int i, boolean buying) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "," + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int cooldown = dfs(prices, i + 1, buying);

        int result;
        if (buying) {
            int buy = dfs(prices, i + 1, false) - prices[i];
            result = Math.max(buy, cooldown);
        } else {
           
            int sell = dfs(prices, i + 1, true) + prices[i] - fee;
            result = Math.max(sell, cooldown);
        }
        dp.put(key, result);
        return result;
    }
}
