class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums , right) - count(nums , left-1);
    }

    private int count(int[] nums , int bound) {
        int curr = 0 , res = 0;

        for(int num : nums) {
            if(num <= bound) {
                curr++;
            }
            else curr = 0;
            res += curr;
            
        }
        
        return res;
    }
}