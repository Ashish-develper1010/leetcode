class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        // if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '#') {
                s1.push(s.charAt(i));
            }
            else if (!s1.isEmpty()){
                s1.pop();
            }
        }

        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) != '#') {
                t1.push(t.charAt(i));
            }
            else if (!t1.isEmpty()){
                t1.pop();
            }
        }

        if(t1.size() != s1.size()) return false;
        int size = t1.size();
        for(int i = 0; i < size; i++) {
            char a = t1.pop();
            char b = s1.pop();
            if(a != b) return false;
        }
        return true;
    }
}