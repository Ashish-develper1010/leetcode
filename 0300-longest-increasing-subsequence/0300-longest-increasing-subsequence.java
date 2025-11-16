class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] num : dp) {
            Arrays.fill(num , -1);
        }
        return helper(nums,dp,0,-1);
    }

    private int helper(int[] nums, int[][] dp  , int curr , int prev) {
        if(curr == nums.length) return 0;

        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];


        int nontake = helper(nums  ,dp, curr+1 , prev);

        int take  = 0;


        if(prev == -1 || nums[curr] > nums[prev]) {
            take = 1+helper(nums  ,dp, curr+1,curr);

            
        }
        return dp[curr][prev+1] = Math.max(take, nontake);
        // return Math.max(take,nontake);
    }
}