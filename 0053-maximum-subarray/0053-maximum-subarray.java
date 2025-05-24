class Solution {
    public int maxSubArray(int[] nums) {
        int currsum = 0;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            currsum += num;
            max = Math.max(max , currsum);
            if(currsum < 0) currsum = 0;
        }
        return max;
    }
}