class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        int i = k;
        while(i <= s.length()) {
            String str = s.substring(i-k , i);
            set.add(str);
            i++;
        }

        return set.size() >= Math.pow(2,k);
    }
}