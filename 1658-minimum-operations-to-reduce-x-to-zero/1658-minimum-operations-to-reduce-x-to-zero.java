class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        sum = sum-x;
        if(sum < 0) return -1;
        if(sum == 0) return nums.length;

        int start = 0;
        int end = 0;
        int maxLen = 0;

        while(end < nums.length) {
            sum -= nums[end];
            
            while(sum < 0) {
                sum += nums[start];
                start++;
            }
            if(sum == 0) {
                maxLen = Math.max(maxLen , end - start +1);
            }
            end++;
        }
        return maxLen == 0 ? -1 : nums.length - maxLen;
    }
}