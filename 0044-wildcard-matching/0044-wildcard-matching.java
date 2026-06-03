class Solution {
    public boolean isMatch(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;

        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        for(int j = 1; j < dp[0].length; j++) {
            if(t.charAt(j-1) == '*') 
                dp[0][j] = dp[0][j-1];
            else 
                dp[0][j] = false;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i -1) == t.charAt(j - 1) || t.charAt(j - 1) == '?') 
                    dp[i][j] = dp[i-1][j-1];
                else if(t.charAt(j - 1) == '*')
                    dp[i][j] = (dp[i][j-1] || dp[i-1][j]);
                else dp[i][j] = false;
            }
        }

        return dp[len1][len2];

    }
}