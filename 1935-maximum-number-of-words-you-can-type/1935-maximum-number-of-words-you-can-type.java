class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> brokenKeys = new HashSet<>();

        for(char ch : brokenLetters.toCharArray()) {
            brokenKeys.add(ch);
        }
        StringBuilder sb = new StringBuilder(text);
        sb.append(" ");
        int i = 0;
        int count = 0;
        boolean canType = true;
        while(i < sb.length()) {
            char ch = sb.charAt(i);
            if(ch == ' '){
                if(canType) count++;
                canType = true;
            }
            if(brokenKeys.contains(ch)) canType = false;
            i++;
        }
        return count;
    }
}