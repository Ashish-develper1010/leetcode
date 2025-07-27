class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            int prev = nums[i - 1], next = nums[i + 1];

            if (nums[i] == nums[i + 1]) {
                int j = i + 1;
                while (j < n - 1 && nums[i] == nums[j])
                    j++;
                next = nums[j];
            }

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > prev && nums[i] > next)
                count++;
            else if (nums[i] < prev && nums[i] < next)
                count++;
            System.out.print(count + " -> " + i + " ");
        }
        return count;
    }
}