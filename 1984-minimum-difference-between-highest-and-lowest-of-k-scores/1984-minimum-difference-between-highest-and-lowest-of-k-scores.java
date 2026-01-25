class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        
        int minDifference = Integer.MAX_VALUE;
        if(k <= 0) return -1;

        int left = 0 , right = k - 1;
        while(right < nums.length) {
            int diff = nums[right] - nums[left];
            minDifference = Math.min(minDifference , diff);
            left++;
            right++;
        }
        return minDifference;
    }
}