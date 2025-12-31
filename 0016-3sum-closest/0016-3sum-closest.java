class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int closest = Integer.MAX_VALUE;

        for(int i = 0; i < len - 2; i++) {

            int j = i + 1;
            int k = len - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                
                if(sum < target) j++;
                else k--;
            }
        }
        return closest;
    }
}