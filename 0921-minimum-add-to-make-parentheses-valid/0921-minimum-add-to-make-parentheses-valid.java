class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count1 = 0;
        int count2 = 0;

        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && c == ')' && st.peek() == '(') 
                st.pop();
            else st.push(c);
        }

        return st.size();
    }
}