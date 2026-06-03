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
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(s, 0 , len -1, dp);   

    }
}