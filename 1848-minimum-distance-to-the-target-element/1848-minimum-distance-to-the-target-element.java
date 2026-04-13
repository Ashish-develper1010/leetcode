class Solution {
    public int getMinDistance(int[] nums, int target, int start) {

        int left = start , right = start;

        while(left >= 0 || right < nums.length) {
            if(left >= 0 && nums[left] == target ) return Math.abs(left - start);
            if(right < nums.length && nums[right] == target ) return Math.abs(right - start);
            left--;
            right++;
        }

        return -1;
    }
}