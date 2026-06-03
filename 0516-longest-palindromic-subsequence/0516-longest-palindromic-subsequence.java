class Solution {
    public int helper(String s, int i, int j, int[][] dp) {
        if(i > j) return 0;

        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) 
            return dp[i][j] =  2 + helper(s, i + 1, j - 1,dp);
        else return dp[i][j] = Math.max(helper(s, i+1, j,dp), helper(s, i, j-1,dp));
        
    }
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == rev.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}
