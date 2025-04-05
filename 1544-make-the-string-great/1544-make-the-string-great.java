class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>(); // Creating a new Stack 

        for(char ch : s.toCharArray()) { // convert string to char Array
            if(!st.isEmpty() && Math.abs(st.peek() - ch) == 32) st.pop();  // check differ Element also by case
            else st.push(ch);
        }

        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}