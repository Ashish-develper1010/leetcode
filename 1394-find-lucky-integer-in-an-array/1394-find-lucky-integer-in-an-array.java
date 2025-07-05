class Solution {
    public int findLucky(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int num : arr) {
            max = Math.max(max , num);
        }
        int[] freq = new int[max+1];

        for(int ele : arr) {
            freq[ele]++;
        }

        int count = 0;
        for(int i = 1; i < freq.length; i++) {
            if(freq[i] == i) count = freq[i];
        }

        return count == 0 ? -1 : count;
    }
}