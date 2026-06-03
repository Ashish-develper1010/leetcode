class Solution {
    public int helper(int[] nums, int i, int[] dp) {
        if(i  >= nums.length - 1) return 0;

        if(dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;

        for(int j = 1; j <= nums[i]; j++) {
            if(j + i< nums.length) {
                int jumps = helper(nums, j + i, dp);
                if(jumps != Integer.MAX_VALUE) 
                    min = Math.min(1+ jumps, min);
            }
        }
        return dp[i] = min;
        // return ans;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
}