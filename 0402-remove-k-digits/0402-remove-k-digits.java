class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // Remove remaining `k` digits from the end if needed
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build the result
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse(); // Correct way to reverse

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If empty, return "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
