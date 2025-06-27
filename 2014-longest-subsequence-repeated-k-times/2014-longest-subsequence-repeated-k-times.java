class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Character> list = new ArrayList<>();

        for(int fr = 25; fr >= 0; fr--) {
            if(freq[fr] >= k) {
                list.add((char)(fr + 'a'));
            }
        } 

        Queue<String> q = new LinkedList<>();

        for(char ch : list) {
            q.add(String.valueOf(ch));
        }
        
        String ans = "";

        while(!q.isEmpty()) {
            String curr = q.poll();

            if(curr.length() > ans.length()) {
                ans = curr;
            }

            for(char ch : list) {
                String next = curr + ch;
                if(istrue(s , next  , k)) {
                    q.add(next);
                }
            }
        }
        return ans;

    }


    public boolean istrue(String s , String t , int k) {
        int pos = 0 , match = 0;
        int m = t.length();

        for(char ch : s.toCharArray()) {
            if(ch == t.charAt(pos)) {
                pos++;

                if(pos == m) {
                    pos = 0;
                    match++;
                    if(match == k) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}