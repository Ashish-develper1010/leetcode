class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if(len == 0) return 0;   // if length is 0 then no operation possible.

        HashMap<Character , Integer> freqMap = new HashMap<>();

        int start = 0 , end = 0;
        int maxLen = Integer.MIN_VALUE;

        while(end < len) {
            char ch = s.charAt(end);

            freqMap.put(ch , freqMap.getOrDefault(ch , 0)+1);  // count freq of current window

            while(freqMap.get(ch) >= 2) {
                char c = s.charAt(start);
                freqMap.put(c , freqMap.get(c)-1);   // manage freq to be unique.
                if(freqMap.get(c) == 0) freqMap.remove(c);

                start++;
            }

            maxLen = Math.max(maxLen , end - start + 1);   // manage count of length of unique subarray.
            end++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;  // idea to return smartly.
    }
}