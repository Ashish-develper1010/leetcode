public class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxTripletValue = 0;
        int maxDiff = 0; // max(nums[i] - nums[j])
        int maxNum = 0;  // max(nums[i])

        for (int num : nums) {
            maxTripletValue = Math.max(maxTripletValue, (long) maxDiff * num); // num corresponds to nums[k]
            maxDiff = Math.max(maxDiff, maxNum - num); // num corresponds to nums[j]
            maxNum = Math.max(maxNum, num);            // num corresponds to nums[i]
        }

        return maxTripletValue;
    }
}
