class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n]; // prefix[i] = sum(nums[0..i-1])
        int[] suffix = new int[n]; // suffix[i] = sum(nums[i+1..n-1])

        // build prefix sums
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        // build suffix sums
        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] + nums[i + 1];
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) continue; // must start on zero
            if (prefix[i] == suffix[i]) ans += 2; // both directions valid
            else if (Math.abs(prefix[i] - suffix[i]) == 1) ans += 1; // exactly one direction
        }
        return ans;
    }
}
