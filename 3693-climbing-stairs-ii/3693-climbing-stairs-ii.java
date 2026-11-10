class Solution {

    public int helper(int n, int i, int[] costs, int[] arr) {

        if (i == 0) {
            return 0;
        }

        if (arr[i] != -1) {
            return arr[i];
        }

        int ans = Integer.MAX_VALUE;

        // Jump 1 step
        if (i >= 1) {
            ans = Math.min(ans,
                    helper(n, i - 1, costs, arr)
                    + costs[i - 1] + 1);
        }

        // Jump 2 steps
        if (i >= 2) {
            ans = Math.min(ans,
                    helper(n, i - 2, costs, arr)
                    + costs[i - 1] + 4);
        }

        // Jump 3 steps
        if (i >= 3) {
            ans = Math.min(ans,
                    helper(n, i - 3, costs, arr)
                    + costs[i - 1] + 9);
        }

        return arr[i] = ans;
    }

    public int climbStairs(int n, int[] costs) {

        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);

        arr[0] = 0;

        return helper(n, n, costs, arr);
    }
}