public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

    // NAIVE APPRAOCH GIVING TLE
/*
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            int max = nums[i];
            for(int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                if(max >= left && max <= right) count++;
            }
        }
        return count;

*/


        // OPTIMAL APPROACH 
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int bound) {
        int res = 0, curr = 0;
        for (int num : nums) {
            if (num <= bound) {
                curr++;
            } else {
                curr = 0;
            }
            res += curr;
        }
        return res;
    }
}
