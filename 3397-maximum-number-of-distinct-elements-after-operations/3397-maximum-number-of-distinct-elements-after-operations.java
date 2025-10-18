class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        long prev = Long.MIN_VALUE; // use long to prevent overflow

        for (int num : nums) {
            // we can move current num anywhere from num - k to num + k
            long start = num - k;
            long end = num + k;

            // choose the smallest value >= prev + 1 to keep distinct
            long chosen = Math.max(prev + 1, start);

            if (chosen <= end) { // valid distinct placement
                count++;
                prev = chosen;
            }
        }

        return count;
    }
}
