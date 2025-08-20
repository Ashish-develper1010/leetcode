class Solution {
    public int countSquares(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int dp[][] = new int[rowLen][colLen];

        for(int i = 0; i < rowLen; i++) {
            dp[i][0] = matrix[i][0];
        }
        for(int j = 0; j < colLen; j++) {
            dp[0][j] = matrix[0][j];
        }    

        for(int i = 1; i < rowLen; i++) {
            for(int j = 1; j < colLen; j++) {
                if(matrix[i][j] == 0) dp[i][j] = 0;
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1] , dp[i-1][j-1]));
                }
            }
        }

        int ans = 0;

        for(int[] arr : dp) {
            for(int ele : arr) {
                ans += ele;
            }
        }

        return ans;
    }
}