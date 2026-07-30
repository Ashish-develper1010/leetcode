import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map to store prefix sum frequencies
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: sum = 0 occurs once

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // If (sum - k) exists, it means there is a subarray ending here with sum = k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Update frequency of current prefix sum
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
