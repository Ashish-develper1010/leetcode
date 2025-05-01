class Solution {
    public int maxSubArray(int[] nums) {
       int l =nums.length;
       int currsum =0 , max = Integer.MIN_VALUE;
       for(int i=0;i<l;i++)
       {
        if(nums[i]<0)
        {
            max = Math.max(nums[i],max);
        }
        if(currsum<0)
        {
            currsum=0;
        }
        currsum+= nums[i];
        max = Math.max(currsum,max);
       } 
       return max;
    }
}