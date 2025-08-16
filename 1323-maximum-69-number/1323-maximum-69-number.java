class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '6') {
                sb.deleteCharAt(i);
                sb.insert(i , '9');
                break;
            }
        }
        String s = sb.toString();
        int ans = Integer.parseInt(s);
        return ans;
    }
}