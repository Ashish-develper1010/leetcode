class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;

        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(isPalindrome(s, i, j)) count++;
            }
        }

        return count;
    }

    public boolean isPalindrome(String str, int i, int j) {
        if( i > j) return true;
        if(i == j) return true;

        if(str.charAt(i) != str.charAt(j)) return false;

        else return isPalindrome(str, i+1, j-1);
    }
}