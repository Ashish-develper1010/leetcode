class Solution {
    public boolean checkOnesSegment(String s) {
        int i = 0, j = s.length() - 1;

        while(i <= j && s.charAt(i) == '0') i++;
        while(i <= j && s.charAt(j) == '0') j--;
        while(i <= j) {
            if(s.charAt(i) == '0' || s.charAt(j) == '0') return false;
            i++;
            j--;
        }
        return true;
    }
}