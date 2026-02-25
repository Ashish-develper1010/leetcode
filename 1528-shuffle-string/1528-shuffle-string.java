class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];

        for(int i = 0; i < indices.length; i++) {
            // char ch = s.charAt(idx);
            arr[indices[i]] = s.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for(char ch  : arr) sb.append(ch);
        return sb.toString();
    }
}