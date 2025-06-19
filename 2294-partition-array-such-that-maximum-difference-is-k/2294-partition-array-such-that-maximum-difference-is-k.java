class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0 , end = 0;
        int count  = 0;
        boolean flag = false;

        while(end < nums.length) {
            if(nums[end] - nums[start] <= k) {
                if(!flag) {
                    flag = true;
                    count++;
                }
                end++;
            }
            else {
                flag = false;
                start = end;
            }
        }
        return count;
    }
}