class Solution {
    // public int countSquares(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int[][] dp = new int[m+1][n+1];
    //     for(int[] d : dp) {
    //         Arrays.fill(d , -1);
    //     }
    //     int total = 0;
    //     for(int i = 0; i < m; i++) {
    //         for(int j = 0; j < n; j++) {
    //             total += helper(matrix, i, j, dp);
    //         }
    //     }
    //     return total;
    // }
    // public int helper(int[][] matrix, int i , int j, int[][] dp) {
    //     if(i < 0 || j < 0) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(matrix[i][j] == 1) {
    //         return dp[i][j] = 1 + Math.min(helper(matrix, i - 1, j, dp), Math.min(helper(matrix, i, j -1, dp), helper(matrix , i - 1, j - 1, dp)));
    //     }
    //     return 0;
    // }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n =  matrix[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }

        for(int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) dp[i][j] = 0;
                else {
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1]));
                }
            }
        }

        int  ans = 0;

        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                ans += dp[i][j];
            }

        }

        return ans;
    }
}