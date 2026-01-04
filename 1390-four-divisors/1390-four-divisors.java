class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for(int num : nums) {
            int sum  = 0;
            int count = 0;

            for(int i = 1; i <= (int)Math.sqrt(num); i++) {
                if(num % i == 0) {
                    count++;
                    sum += i;
                    sum += num / i;
                    if(i * i == num) {
                        count++;
                        sum = 0;
                    }
                }
                if(count > 2) break;
            }
            if(count == 2) {
                totalSum += sum;
            }
        }
        return totalSum;
    }
}