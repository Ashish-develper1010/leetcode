class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        String flipedBinary = flip(binary);
        int res = Integer.parseInt(flipedBinary,2);
        return res;
    }

    private String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == '0') sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }
}