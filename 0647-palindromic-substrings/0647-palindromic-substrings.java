class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;

        Boolean[][] dp = new Boolean[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(isPalindrome(s, i, j, dp)) count++;
            }
        }

        return count;
    }

    public boolean isPalindrome(String str, int i, int j, Boolean[][] dp) {
        if( i > j) return true;
        if(i == j) return true;

        if(dp[i][j] != null) return dp[i][j];

        if(str.charAt(i) != str.charAt(j)) return dp[i][j] = false;

        else return dp[i][j] = isPalindrome(str, i+1, j-1, dp);
    }
}