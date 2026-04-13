class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minAnswer = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                minAnswer = Math.min(minAnswer , Math.abs(i - start));
            }
        }

        return minAnswer;
    }
}