class Solution {
    public int helper(int n, int d, int[] arr, int[] dp) {

        if(dp[n] != -1) return dp[n];

        int ans = 1;

        for(int i = 1; i <= d && n + i < arr.length; i++) {

            if(arr[n + i] >= arr[n]) break;
            
            if(arr[n + i] < arr[n]) 
                ans = Math.max(ans,1 + helper(n + i, d, arr, dp));
        }

        for(int i = 1; i <= d && n - i >= 0; i++) {
            if(arr[n - i] >= arr[n]) break;

            if(arr[n - i] < arr[n]) 
                ans = Math.max(ans, 1 + helper(n - i, d, arr, dp));
        }
        return dp[n] = ans;
    }
    public int maxJumps(int[] arr, int d) {
        int len = arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp , -1);

        int max = 0;
        for(int i = 0; i < len; i++) {
            max = Math.max(max, helper(i, d, arr, dp));
        }


        // for(int ele : dp) max = Math.max(max, ele);

        return max;
    }
}