class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] d : dp) {
            Arrays.fill(d , -1);
        }
        int total = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                total += helper(matrix, i, j, dp);
            }
        }
        return total;
    }
    public int helper(int[][] matrix, int i , int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(matrix[i][j] == 1) {
            return dp[i][j] = 1 + Math.min(helper(matrix, i - 1, j, dp), Math.min(helper(matrix, i, j -1, dp), helper(matrix , i - 1, j - 1, dp)));
        }
        return 0;
    }
}