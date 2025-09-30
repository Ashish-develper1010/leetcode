class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        while(n != 1) {
            // int[] arr = new int[n-1];
            for(int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            nums[n-1] = 0;
            n--;
        }
        int sum = nums[0];
        return sum;
    }
}