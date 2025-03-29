class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
        int[] windowcount = new int[26];

        int s1l = s1.length();
        int s2l = s2.length();

        for(int i = 0; i < s1l; i++) {
            s1count[s1.charAt(i )-'a']++;
        }

        for(int i = 0; i < s2l; i++) {
            windowcount[s2.charAt(i)-'a']++;

            if(i >= s1l) {
                windowcount[s2.charAt(i - s1l) - 'a']--;
            }
            if(match(s1count , windowcount)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(int[] arr , int[] nums) {
        for(int i = 0; i < 26; i++) {
            if(arr[i] != nums[i]) return false;
        }
        return true;
    }
}