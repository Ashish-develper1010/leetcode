class Solution {
    // public int solve(int[] cost, int n, int[] dp) {
    //     if(n == 0 || n == 1) return cost[n];

    //     if(dp[n] != -1) return dp[n];
         
    //     return dp[n] =  cost[n] + Math.min(solve(cost , n-1,dp) , solve(cost , n-2,dp));

    // }
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        // Arrays.fill(dp , -1);
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < len ; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1] , dp[i-2]);
        }

        return Math.min(dp[len - 1], dp[len - 2]);
    }
}