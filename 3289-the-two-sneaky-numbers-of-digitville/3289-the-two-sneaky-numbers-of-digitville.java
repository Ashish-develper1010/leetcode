class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        if(nums == null || nums.length < 2) return new int[0];
        int[] res = new int[2];
        int k = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) res[k++] = nums[i];
        }
        return res;
    }
}