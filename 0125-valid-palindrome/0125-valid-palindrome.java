class Solution {
    public boolean isPalindrome(String s) {
        
         // to Convert in lower and replace every charater that is not inn range of A-Z , a-z, 0-9 with "" 
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");

        // apply palindrome function 
        
        int i = 0,  j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;

        }
        return true;
    }
}