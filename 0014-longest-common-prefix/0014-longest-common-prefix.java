class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0) return "";
        StringBuilder res = new StringBuilder();

        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[n-1].toCharArray();

        for(int i = 0; i < first.length; i++) {
            if(first[i] == last[i]) 
                res.append(first[i]);
            else break;
        }
        return res.toString();
    }

}
