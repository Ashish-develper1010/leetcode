class Solution {

    public boolean helper(int[] nums, Boolean[][] dp, int sum, int i) {
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(i >= nums.length) return false;

        if(dp[i][sum] != null) return dp[i][sum];

        boolean take = helper(nums, dp, sum - nums[i], i + 1);
        boolean nontake = helper(nums, dp, sum, i + 1);

        return dp[i][sum] = take || nontake;

    }
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        if(totalSum % 2 != 0) return false;

        int sum = totalSum / 2;
        Boolean[][] dp = new Boolean[len][sum+1];

        return helper(nums, dp, sum, 0);
    }
}