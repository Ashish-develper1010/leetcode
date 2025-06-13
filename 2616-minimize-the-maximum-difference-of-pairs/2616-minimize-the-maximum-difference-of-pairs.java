class Solution {
    public static boolean isPossible(int[] nums, int p, int mid) {
        int ps = 0, left = 1;
        while (left < nums.length) {
            if (nums[left] - nums[left - 1] <= mid) {
                left += 2;
                ps++;
            } else {
                left++;
            }
        }
        return ps >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int min = 0;

        int max = nums[nums.length - 1] - nums[0];

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isPossible(nums, p, mid)) {

                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}