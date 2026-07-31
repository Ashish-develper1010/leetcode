class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            if(num % 2 != 0) continue;
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        for(int key : freqMap.keySet()) {
            maxFreq = Math.max(maxFreq, freqMap.get(key));
        }

        int ans = Integer.MAX_VALUE;

        for(int key : freqMap.keySet()) {
            if(freqMap.get(key) == maxFreq) {
                ans = Math.min(ans, key);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}