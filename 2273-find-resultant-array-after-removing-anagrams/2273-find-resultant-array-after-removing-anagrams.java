class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();

        if(words.length == 0 || words == null) return new ArrayList<>();

        res.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            String current = words[i];
            String prev = words[i-1];

            if(!sort(current).equals(sort(prev))) {
                res.add(current);
            }
        }

        return res;
    }

    private String sort(String s) {
        char[] ch = s.toCharArray();

        Arrays.sort(ch);

        return Arrays.toString(ch);
    }
}