class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int del = 0;

        for(char ch : s.toCharArray()) {
            if(ch == 'b') 
                bCount++;
            else // c == 'a' 
                del = Math.min(del + 1 , bCount);
        }
        return del;
    }
}