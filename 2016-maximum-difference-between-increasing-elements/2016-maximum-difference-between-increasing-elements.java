class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            ans = nums[i] - min;
            max = Math.max(max , ans);
        }
        return max == 0 ? -1 : max;
    }
}