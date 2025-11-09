class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return helper(nums , dp , 0);
    }

    private int helper(int[] nums , int[] dp, int i) {
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        int take = nums[i] + helper(nums , dp , i+2 );
        int nontake = helper(nums, dp , i+1);

        dp[i] = Math.max(take , nontake);
        return dp[i];
    }
}