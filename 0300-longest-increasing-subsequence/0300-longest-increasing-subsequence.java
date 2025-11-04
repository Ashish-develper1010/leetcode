class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 0 || nums == null) return 0;
        if(nums.length == 1) return 1;
        int len = nums.length;
        int maxLen = 0;

        int[] dp = new int[len];
        Arrays.fill(dp , 1);

        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i] , dp[j] + 1);
                maxLen = Math.max(dp[i] , maxLen);
            }
        }
        return maxLen;
    }
}