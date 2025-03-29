class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = nums.length+1;

        while(end < nums.length) {
            sum += nums[end];
            while(sum >= target) {
                minLen = Math.min(minLen , end - start +1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minLen == nums.length+1 ? 0 : minLen;
    }
}