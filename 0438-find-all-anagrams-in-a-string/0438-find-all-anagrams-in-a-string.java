import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Frequency map of characters in p
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0, count = map.size(); // count tracks unique chars to match
        int k = p.length();

        while (end < s.length()) {
            char ch = s.charAt(end);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--; // Character matched completely
                }
            }

            if (end - start + 1 == k) { // When window size equals p.length()
                if (count == 0) {
                    result.add(start); // Anagram found
                }

                // Slide window by removing start char
                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        count++; // Losing a completely matched character
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }

                start++; // Shrink window from left
            }
            end++; // Expand window from right
        }

        return result;
    }
}
