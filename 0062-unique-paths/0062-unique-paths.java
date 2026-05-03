class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] d : dp) {
            Arrays.fill(d , -1);
        }
        return helper(0 , 0 , m , n, dp);
    }
    public int helper(int i , int j , int m , int n, int[][] dp) {
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        int rightWays = helper(i , j + 1, m , n, dp);
        int leftWays = helper(i + 1, j , m , n, dp);

        return dp[i][j] = rightWays + leftWays;
    }
}