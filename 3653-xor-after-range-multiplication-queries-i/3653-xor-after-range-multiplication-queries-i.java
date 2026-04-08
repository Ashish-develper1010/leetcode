class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            // Optimization: avoid repeated mod casting
            long mul = v;

            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((nums[i] * mul) % MOD);
            }
        }

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}