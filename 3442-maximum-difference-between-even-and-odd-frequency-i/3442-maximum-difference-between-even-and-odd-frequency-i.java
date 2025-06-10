class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int[] nums = new int[n];
        int idx = 0;

        for(char ch : s.toCharArray()) {
            nums[idx++] = ch - 'a';
        }
        int maxnum = 0;
        for(int num : nums) {
            maxnum = Math.max(maxnum , num);
        }
        int[] freq = new int[maxnum+1];

        for(int num : nums) {
            freq[num]++;
        }

        int min = Integer.MAX_VALUE , max = 0;
        for(int num : freq) {
            if(num == 0) continue;
            if(num % 2 == 0) {
                min = Math.min(min , num);
            }
            else {
                max = Math.max(max , num);
            }
        }
        return max - min;
    }
}