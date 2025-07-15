class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean isContainsVowel = false;
        boolean isContainsConsonant = false;

        for(char ch : word.toCharArray()) {
            if(Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if(isVowel(ch)) isContainsVowel = true;
                else isContainsConsonant = true;
            }
            else if(Character.isDigit(ch)) continue;
            else return false;
            
        }
        if(isContainsVowel && isContainsConsonant) return true;
        return false;
    }
}