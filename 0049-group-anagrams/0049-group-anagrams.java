class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalRes = new ArrayList<>();
        HashMap<String , List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            map.computeIfAbsent(key , k -> new ArrayList<>()).add(str);
        }
        finalRes.addAll(map.values());
        return finalRes;
    }
}