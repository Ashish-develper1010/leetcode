class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] ans = new int[len];
        int j = 0 , k = 0;

        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) ans[i] = nums[j++];
            else ans[i] = nums[k++ + n];
        }
        return ans;
    }
}