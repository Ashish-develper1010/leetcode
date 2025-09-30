class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character , Integer> map = new HashMap<>();

        int start = 0 , end = 0;

        while(end < s.length()) {
            map.put(s.charAt(end) , map.getOrDefault(s.charAt(end) , 0)+1);

            while(map.get(s.charAt(end)) > 1) {
                map.put(s.charAt(start) , map.get(s.charAt(start)) - 1);
                if(map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen , end - start + 1);
            end++;
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}