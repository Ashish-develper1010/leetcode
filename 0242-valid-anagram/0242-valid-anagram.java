class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; //Strings of differ length can never anagram

        int[] freq = new int[26];

        for (int i = 0; i  < s.length(); i++) {
            freq[s.charAt(i)-'a']++; // add freq of each character respective to Sting s
        }
        
        for (int i = 0 ; i < t.length(); i++) {
            freq[t.charAt(i)-'a']--; // decrease the freq respective to t String
        }
        for(int num : freq) {
            // num is greater than 0 it means that String s has more character than String t;
            if(num != 0) return false; // if num is negative then it means that String t has more character than s
        }

        return true; // If exactly matches than return true
    }
}
