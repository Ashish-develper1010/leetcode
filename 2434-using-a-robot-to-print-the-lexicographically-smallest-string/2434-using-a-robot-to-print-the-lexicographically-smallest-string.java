class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] arr = new char[n];

        arr[n-1] = s.charAt(n-1);

        for(int i = n-2; i >= 0; i--) {
            arr[i] = (char) Math.min(arr[i+1] , s.charAt(i));
        }

        int i = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(i < n) {
            st.push(s.charAt(i));
            char minchar = i+1 < n ? arr[i+1] : s.charAt(i);

            while(!st.isEmpty() && st.peek() <= minchar) {
                sb.append(st.pop());
            }
            i++;
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());   
        }
        return sb.toString();
    }
}