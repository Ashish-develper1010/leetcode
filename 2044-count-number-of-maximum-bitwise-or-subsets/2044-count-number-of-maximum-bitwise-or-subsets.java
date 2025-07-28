class Solution {
    int count = 0;
    int target = 0;

    public void dfs(int[] nums, int index, int orVal) {
        if (index == nums.length) {
            if (orVal == target) count++;
            return;
        }

        // Include nums[index]
        dfs(nums, index + 1, orVal | nums[index]);

        // Exclude nums[index]
        dfs(nums, index + 1, orVal);
    }

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            target |= num;  // Get the maximum possible OR
        }

        dfs(nums, 0, 0);
        return count;
    }
}
