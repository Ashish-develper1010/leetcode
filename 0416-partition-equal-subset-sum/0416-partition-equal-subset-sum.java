class Solution {
    public boolean solve(Boolean[][] dp , int[] nums , int i , int sum) {
        if (sum == 0) return true;
        if (i >= nums.length || sum < 0) return false;

        if (dp[i][sum] != null) return dp[i][sum];

        boolean take = solve(dp , nums , i + 1 , sum - nums[i]);
        boolean nontake = solve(dp , nums , i + 1 , sum);

        return dp[i][sum] = take || nontake;
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;
        int sum = totalSum / 2;

        Boolean[][] dp = new Boolean[nums.length][sum + 1];
        return solve(dp, nums, 0, sum);
    }
}
