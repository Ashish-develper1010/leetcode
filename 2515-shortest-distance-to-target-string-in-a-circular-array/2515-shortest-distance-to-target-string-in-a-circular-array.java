class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int left = startIndex;
        int right = startIndex;
        int count = 0;
        int len = words.length;

        while(count < len) {

            if(words[left].equals(target)) return count;
            else if(words[right].equals(target)) return count;
            left = (left - 1 + len) % len;
            right = (right + 1) % len;

            count++;
        }
        return -1;
    }
}