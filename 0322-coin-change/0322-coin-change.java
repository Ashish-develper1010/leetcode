class Solution {
    public int helper(int[] coins, int sum, int[] dp) {
        if(sum == 0) return 0;

        if(sum < 0) return Integer.MAX_VALUE;

        if(dp[sum] != -1) return dp[sum];

        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++) {
            int res = helper(coins, sum - coins[i], dp);

            if(res != Integer.MAX_VALUE) mini = Math.min(mini, 1+res);
        }
        return dp[sum] = mini;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp ,-1);
        int ans =  helper(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}