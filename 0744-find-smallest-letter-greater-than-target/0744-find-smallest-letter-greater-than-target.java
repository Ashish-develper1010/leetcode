class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        for(int i = 0; i < letters.length; i++) {
            // char ch = letters.charAt(i);
            if(letters[i] > target) return letters[i];
        }
        return letters[0];
    }
}