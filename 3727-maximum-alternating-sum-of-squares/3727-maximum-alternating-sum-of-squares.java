class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        long[] sqArray = new long[len];

        for(int i = 0; i < len; i++) {
            sqArray[i] = nums[i] * nums[i];
        }

        Arrays.sort(sqArray);

        long sum = 0;

        for(int i = 0; i < len/2; i++) {
            sum += sqArray[len - i - 1] - sqArray[i];
        }

        if(len % 2 == 1) sum += sqArray[len / 2];

        return sum;
    }
}

/*  
1  -1 2 -2  3  -3
1 1 4 4 9 
1 1 2 2 3 3
9 - 1, 9 - 1, 4 - 4
8 + 8 = 16

*/