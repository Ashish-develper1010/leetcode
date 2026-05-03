class Solution {
    public int recursion(int[][] obstacleGrid , int m, int n) {
        if(m < 0 || n < 0) return 0;
        if(obstacleGrid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;

        // VALID

        int rightWays = recursion(obstacleGrid, m , n-1);
        int downWays = recursion(obstacleGrid, m-1 , n);

        return rightWays + downWays;
    }

    public int memoization(int[][] obstacleGrid, int m , int n , int[][] dp) {
        if(m < 0 || n < 0) return 0;
        if(obstacleGrid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;

        if(dp[m][n] != -1) return dp[m][n];

        int rightWays = memoization(obstacleGrid, m , n-1, dp);
        int downWays = memoization(obstacleGrid, m-1 , n, dp);

        return dp[m][n] = rightWays + downWays;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return recursion(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] d : dp) {
            Arrays.fill(d , -1);
        }

        return memoization(obstacleGrid, m-1, n-1, dp);
    }
}