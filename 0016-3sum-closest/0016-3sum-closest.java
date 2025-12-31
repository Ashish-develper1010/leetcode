class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++) {
                for(int k = j+1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(target - sum) < Math.abs(target - diff))
                        diff = sum;
                    
                }
            }
        }
        return diff;
    }
}