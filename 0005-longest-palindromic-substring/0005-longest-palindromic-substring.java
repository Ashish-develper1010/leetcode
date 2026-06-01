class Solution {

    public boolean isPalindrome(String s, int i, int j) {
        if(i == j) return true;

        while( i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int maxLength = Integer.MIN_VALUE;

        String ans = "";

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(isPalindrome(s, i , j)) {
                    if(maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        ans = s.substring(i , j + 1);
                    }
                }
            }
        }

        return ans;
    }
}