class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;

        for(int i = 0; i < len; i++) {
            for(int j = i+1; j <= len; j++) {
                String str = s.substring(i , j);
                if(isPalindrome(str)) count++;
            }
        }

        return count;
    }

    public boolean isPalindrome(String str) {
        int len = str.length();
        if(len == 1) return true;

        int start = 0, end = len - 1;

        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}