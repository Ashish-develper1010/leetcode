class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int maxLength = 0;

        for(int i = 0; i < n; i++)
        {
            int inc = 1;
            for(int j = i + 1; j < n; j++)
            {
                if(nums[j] > nums[j-1]) inc++;
                else break;
            }

            int dec = 1;
            for(int j = i + 1; j < n; j++)
            {
                if(nums[j] < nums[j-1]) dec++;
                else break;
            }

            maxLength = Math.max(maxLength , Math.max(inc , dec));
        }
        return maxLength;
    }
}