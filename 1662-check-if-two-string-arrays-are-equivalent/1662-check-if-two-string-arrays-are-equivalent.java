class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(String ch : word1) {
            str1.append(ch);
        }
        for(String ch : word2) {
            str2.append(ch);
        }
        return str1.toString().equals(str2.toString());
    }
}