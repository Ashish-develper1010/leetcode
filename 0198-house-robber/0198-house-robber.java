class Solution {
    // --> recursion <--

    // public int helper(int[] nums , int n) {
        // if(n == 0) return nums[0];
        // if(n == 1) return Math.max(nums[0] , nums[1]);

        // int take = nums[n] + helper(nums , n - 2);
        // int nonTake = helper(nums , n -1);

    //     return Math.max(take , nonTake);
    // }
    // public int rob(int[] nums) {
    //     return helper(nums , nums.length - 1);
    // }

    // --> Memoization <--
    // public int helper(int[] nums , int n , int[] dp) {
        // if(n == 0) return nums[0];
        // if(n == 1) return Math.max(nums[0] , nums[1]);

    //     if(dp[n] != -1) return dp[n];

    //     int take = nums[n] + helper(nums , n - 2, dp);
    //     int nonTake = helper(nums , n -1, dp);

    //     return dp[n] = Math.max(take, nonTake);

    // }
    // public int rob(int[] nums) {
    //     int len = nums.length;
    //     int[] dp = new int[len];
    //     Arrays.fill(dp , -1);

    //     return helper(nums , len - 1, dp);
    // }

    public int rob(int[] nums) {
        int len = nums.length;


        if(len == 0) return nums[0];
        if(len == 1) return Math.max(nums[0] , nums[1]);

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);
        
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] , dp[i-2] + nums[i]);
        }

        return dp[len - 1];
    }
}