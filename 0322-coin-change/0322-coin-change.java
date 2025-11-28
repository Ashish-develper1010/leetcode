class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int []dp = new int[amount+1];
        dp[0]=0;
        for(int i =1;i<=amount;i++)
        {
            dp[i] = amount+1;

        }
        for(int coin:coins)
        {
            for(int amt = coin;amt<=amount;amt++)
            {
                dp[amt]=Math.min(dp[amt-coin]+1,dp[amt]);
            }
        }
        return dp[amount]<=amount?dp[amount]:-1;
    }
}