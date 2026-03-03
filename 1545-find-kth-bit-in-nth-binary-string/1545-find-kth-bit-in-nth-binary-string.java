class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');

        for(int i = 1; i < n; i++) {
            if(sb.length() >= k) return sb.charAt(k-1);

            String binary = sb.toString();
            sb.append('1');
            StringBuilder fliped = new StringBuilder(flip(binary));
            sb.append(fliped.reverse());
        }


        return sb.charAt(k-1);
    }


    private StringBuilder flip(String str) {
        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()) {
            if(ch == '0') sb.append('1');
            else sb.append('0');
        }

        return sb;
    }
}