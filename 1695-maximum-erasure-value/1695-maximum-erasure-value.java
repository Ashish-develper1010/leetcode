class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxSum = 0;
        int sum = 0;

        while(end < nums.length) {
            sum += nums[end];
            map.put(nums[end] , map.getOrDefault(nums[end] , 0)+1);
            while(map.get(nums[end]) > 1 && start <= end) {
                sum -= nums[start];
                if(map.get(nums[start]) == 1) map.remove(nums[start]);
                else map.put(nums[start] , map.get(nums[start]) - 1);
                start++;
            }
            maxSum = Math.max(maxSum , sum);
            end++;
        }
        return maxSum;
    }
}