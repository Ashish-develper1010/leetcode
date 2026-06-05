class Solution {
    public int helper(int[] prices, int i, int buy, int ans) {
        if(i == prices.length) return ans;

        if(prices[i] < buy) 
            return helper(prices, i+1, prices[i], ans);
        ans = Math.max(ans, prices[i] - buy);
        return helper(prices, i+1, buy, ans);
    }
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        return helper(prices, 0, prices[0], ans);
    }
}