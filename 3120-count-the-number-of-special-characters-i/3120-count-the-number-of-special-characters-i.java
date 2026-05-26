class Solution {
    public char changeCase(char ch) {
        String str = String.valueOf(ch);
        String s = str.toUpperCase();

        if(str.equals(s)) 
            return str.toLowerCase().charAt(0);
        return s.charAt(0);
    }
    public int numberOfSpecialChars(String word) {
        Set<Character> map = new HashSet<>();
        int count = 0;

        for(char ch : word.toCharArray()) {
            if(map.contains(ch)) continue;
            map.add(ch);
            char c = changeCase(ch);
            if(map.contains(c)) {
                count++;
            }
        }
        return count;
    }
}