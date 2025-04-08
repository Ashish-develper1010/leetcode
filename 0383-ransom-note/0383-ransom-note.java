class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()) {
            map.put(c , map.getOrDefault(c , 0)+1);
        }

        for(char ch : ransomNote.toCharArray()) {
            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) map.put(ch , map.get(ch)-1);
                else return false;
            }
            else return false;
        }
        return true;
    }
}