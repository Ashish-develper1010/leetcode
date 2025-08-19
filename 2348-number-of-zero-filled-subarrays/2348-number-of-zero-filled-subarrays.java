class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int sum = 0;
        int currentIndex = 0;
        int sumIndex = -1;
        long ans = 0;

        while(currentIndex < nums.length) {
            int temp = sum;
            sum += nums[currentIndex];
            if(sum != temp) sumIndex = currentIndex;

            ans += currentIndex - sumIndex;
            currentIndex++;
        }
        return ans;
    }
}