class Solution {
    public boolean canBeEqual(String s1, String s2) {
        
        // Check even indices
        char a1 = s1.charAt(0), a2 = s1.charAt(2);
        char b1 = s2.charAt(0), b2 = s2.charAt(2);
        
        if (!((a1 == b1 && a2 == b2) || (a1 == b2 && a2 == b1))) {
            return false;
        }

        // Check odd indices
        char a3 = s1.charAt(1), a4 = s1.charAt(3);
        char b3 = s2.charAt(1), b4 = s2.charAt(3);
        
        if (!((a3 == b3 && a4 == b4) || (a3 == b4 && a4 == b3))) {
            return false;
        }

        return true;
    }
}