class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2) return;

        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if (pivot >= 0) {
            int nextLarger = n - 1;
            while (nums[nextLarger] <= nums[pivot]) {
                nextLarger--;
            }
            swap(nums, pivot, nextLarger);
        }

        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
