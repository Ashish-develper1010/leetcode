class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();

        int ans = 0;

        for(int ele : arr1) {
            String num = String.valueOf(ele);
            String prefix = "";

            for(int i = 0; i < num.length(); i++) {
                prefix += num.charAt(i);
                set.add(prefix);
            }
        }   

        for(int ele : arr2) {
            String num = String.valueOf(ele);
            String prefix = "";

            for(int i = 0; i < num.length(); i++) {
                prefix += num.charAt(i);
                if(set.contains(prefix)) {
                    ans = Math.max(ans, i + 1);
                }
            }
        }
        return ans;
    }
}